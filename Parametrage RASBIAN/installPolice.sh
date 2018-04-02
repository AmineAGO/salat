#!/bin/sh

sudo apt-get install ttf-mscorefonts-installer
cabextract -F 'tahoma*ttf' IELPKTH.CAB
sudo mv -f tahoma*ttf /usr/share/fonts/truetype/msttcorefonts/
sudo chmod 644 /usr/share/fonts/truetype/msttcorefonts/tahoma*
fc-cache -v