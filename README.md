
# Computer Vision for FIRST Robotics

![firstlogo](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.team2052.com%2Fassets%2Fimages%2Ffirstlogo.jpg&f=1&nofb=1&ipt=745e90197c9d987d98c9c16be29742cae4314d2a01173d5948efc7dfe54381a5&ipo=images)

### About:
GRIP is a tool for developing computer vision algorithms interactively rather than through trial and error coding. After developing your algorithm you may run GRIP in headless mode on your roboRIO, on a Driver Station Laptop, or on a coprocessor connected to your robot network. With Grip you choose vision operations to create a graphical pipeline that represents the sequence of operations that are performed to complete the vision algorithm.

GRIP is based on OpenCV, one of the most popular computer vision software libraries used for research, robotics, and vision algorithm implementations. The operations that are available in GRIP are almost a 1 to 1 match with the operations available if you were hand coding the same algorithm with some text-based programming language.

With a GRIP pipeline, you can import the code in to a java library for processing spun up on a microprocessor (like a Raspberry Pi). For this project, I will be using PhotonVision. 

![photonlogo](https://photonvision.org/images/Logos/Header/PNG/PhotonVision-Header-noBG.png)

## Developers

- [Mac Lawson](https://mac-lawson.github.io)



## Guide
![firstlogo](https://i.postimg.cc/Df9qpyXH/Screen-Shot-2022-10-29-at-5-43-18-PM.png)
This is a basic example using GRIP. The example image can be replaced with a camera stream, but I'm using a still image as a demo. 
As you can see, the default image is simulating a field with green light. 
![firstlogo](https://i.postimg.cc/Rq5kF6Z2/Screen-Shot-2022-10-29-at-7-27-56-PM.png)
Now, using GRIP, we can isolate the lines of the image. 

![firstlogo](https://i.postimg.cc/6p7MS56v/Screen-Shot-2022-10-29-at-7-30-27-PM.png)
Lastly, use network tables to send the data to Shuffleboard. 


## Adding Vendor Libs to Robot Project
To recreate this project, you need to import the proper vendor's libraries. 
```
https://maven.photonvision.org/repository/internal/org/photonvision/PhotonLib-json/1.0/PhotonLib-json-1.0.json
```

![wpilibvscode](https://docs.photonvision.org/en/latest/_images/adding-offline-library.png)

