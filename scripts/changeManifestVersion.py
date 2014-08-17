#!/usr/bin/python
################ IMPORTS ################
import os, sys

################ PARAMTERS ################
manifestLocation = "../FireFallMarketplace/AndroidManifest.xml";
versionCode = sys.argv[1];
versionName = sys.argv[2];

################ FUNCTIONS ################
# function to replace occurrences of toReplace with replacement
def replaceInFile(file, toReplace, replacement):
	with open(file,'r') as f:
		newlines = []
		for line in f.readlines():
			newlines.append(line.replace(toReplace, replacement))
	with open(file, 'w') as f:
		for line in newlines:
			f.write(line)

################ BODY ################	

replaceInFile(manifestLocation, "android:versionCode=\"1\"", "android:versionCode=\"" +versionCode +"\"");
replaceInFile(manifestLocation, "android:versionName=\"1.0\" >", "android:versionName=\"" +versionName +"\" >");