#!/bin/sh
sudo systemctl stop app.service
if test -f "/home/ubuntu/app/app.jar"; then
    rm -rf /home/ubuntu/app
fi