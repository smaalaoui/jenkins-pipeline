#!/bin/sh

mkdir -p /home/ubuntu/app
mv /home/ubuntu/app.jar /home/ubuntu/app/app.jar

sudo systemctl start app.service

sleep 30