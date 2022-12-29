# Docker

Docker is a container management tool. With it we can develop and deploy our applications in isolated environments (containers) , speeding up the software development lifecycle.  

Let's start of our discussion about containers by talking about Virtual Machines.  

## [Virtual Machines](https://azure.microsoft.com/en-us/overview/what-is-a-virtual-machine/#overview)

Virtual machines are very much like traditional machines. VMs have the same set of hardware resources (e.g. CPU, RAM, SSD, etc. ) that a 'bare-metal' machine will have, but all of these resources are virtualized.  For the operating system (an operating system on a VM is a 'Guest OS') and any applications running on it, they will treat it as if they are running natively on the system.  

[Why do we use Virtual machines in the first place?](https://www.ibm.com/cloud/blog/5-benefits-of-virtualization) 

There are many benefits to using virtual machines in enterprise servers compared to bare metal servers, but here are a few:  

- Cost savings and Increased efficiency– being able to host multiple virtual servers on a single system means we can purchase fewer physical machines and have our IT team support those systems more effectively  
- Easy Provisioning – replacing physical servers is time consuming, virtual environments can be provisioned in minutes on another server that can replicate the VM that was affected 
- Isolation and DevOps -  Being able to create isolated environments quickly makes it easier to maintain production environments and prepare testing environments for new releases 

## [Containers](https://www.docker.com/resources/what-container/)

A container is a standard unit of software that packages up code and all its dependencies into an isolated environment, this allows it to be run reliably and quickly from one environment to another.  
Containers are similar to virtual machines, but while VMs are virtualized at the hardware level, containers are virtualized at the OS level.  This means that containers are inherently less isolated than VMs and cannot use a different OS to the host machine. We can and do use containers inside of virtual machines.  
Containers are managed by the Docker engine, Virtual Machines are managed by the Hypervisor. 


[What are the benefits of containers?](https://www.netapp.com/devops-solutions/what-are-containers/)

- Lightweight – they require even less system resources than VM because they don't need to provide their own OS 
- Speed and Scalability – VMs take minutes, containers take seconds to deploy. This means that we can scale to meet traffic or redeploy damaged containers in seconds (reducing production environment impact) 
- Isolation and DevOps – being able to create very lightweight and isolated environments makes it easier to maintain production environments and prepare testing environments for new releases 


## [Docker Images](https://jfrog.com/knowledge-base/a-beginners-guide-to-understanding-and-building-docker-images/)
Containers are based of images. An image is simply a recipe, a set of instructions for the Docker engine to tell it how to execute the container.  Images can be built on top of other images, and we can pull pre-built images from the public container registry: Docker Hub.  

## [Docker File](https://docs.docker.com/engine/reference/builder/) 
Docker file lets us create and configure our own custom images where we can specify the image will be building our image on top of, setting up environment variables for the container and commands for the container to execute. 

We create a file called 'Dockerfile' and execute the $docker build –t <image-tag> . (note that the period at the end of the command is necessary)  