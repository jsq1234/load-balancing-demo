#!/bin/bash

# Enable logging 
exec > >(tee /var/log/user-data.log | logger -t user-data -s 2>/dev/console) 2>&1

# Update packages 
sudo yum update -y

# Install java-17 
echo "Installing java-17"
sudo yum install -y java-17-amazon-corretto.x86_64

# install git
echo "Installing git"
sudo yum install -y git

# install iptables
sudo yum install -y iptables

# Clone the repository
echo "Cloning code repository"
git clone https://github.com/jsq1234/load-balancing-demo.git
cd load-balancing-demo/post-service

# Build the project
echo "Building the post-service project"
./mvnw clean package

# Forward HTTP port 80 traffic to 8080 (Spring boot app)
echo "Enabling port forwarding to 8080"
sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-ports 8080

# Run the project
echo "Running the spring boot project"
java -jar target/post-service-0.0.1-SNAPSHOT.jar