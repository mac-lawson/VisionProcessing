from flask import Flask, Response
import threading
import cv2
import time
import argparse

parser = argparse.ArgumentParser(description='Networked stream from a webcam.')
parser.add_argument('-c', '--camera', metavar='N', type=int, help='camera id to stream', default=0)
parser.add_argument('-f', '--fps', metavar='N', type=int, help='framerate of the video stream', default=30)

args = parser.parse_args()


class Webcam(object):
    def __init__(self):
        self.current_frame = None
        self.video = cv2.VideoCapture(args.camera)

    def __del__(self):
        self.video.release()

    def start_stream(self):
        while True:
            time.sleep(1 / args.fps)
            success, image = self.video.read()
            ret, jpeg = cv2.imencode('.jpg', image)
            self.current_frame = jpeg.tobytes()


app = Flask(__name__)

def gen():
    while True:
        time.sleep(1/args.fps)
        frame = stream.current_frame
        yield (b'--frame\r\n'
               b'Content-Type: image/jpeg\r\n\r\n' + frame + b'\r\n\r\n')


@app.route('/')
def video_feed():
    return Response(gen(), mimetype='multipart/x-mixed-replace; boundary=frame')


if __name__ == '__main__':
    stream = Webcam()
    t = threading.Thread(target=stream.start_stream, daemon=True)
    t.start()
    app.run(host='0.0.0.0', threaded=True)
