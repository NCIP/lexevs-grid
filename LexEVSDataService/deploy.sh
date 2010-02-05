#!/bin/sh
# EVSGridsrv deployment script
#

SERVER_NAME=`uname -a|gawk '{print $2}'`

echo
echo "-----------------------------------------"
echo "LexEVS Grid Service Deployment Script 1.0"
echo "-----------------------------------------"
echo SERVER: $SERVER_NAME

case $SERVER_NAME in
    cbvapp-d1007.nci.nih.gov)
        ENV=DEV;;
    cbvapp-q1003.nci.nih.gov)
        ENV=QA;;
    *) echo "Error! Unknown server '$SERVER_NAME'";
       echo "Script can not execute.";
       exit;;
esac
echo

# Prompt user to deploy service

if [ "$1" = "-q" ]
   then
        answer="Y"
   else
        echo "Deploy to $ENV? [Y/N] "; read answer;
fi

# Perform deployments

if [ $answer = "Y" -o $answer = "y" ]
   then
        if [ $ENV = "DEV" ]
           then
                 echo "Deploying to DEV...";
                 if [ `ls /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war | wc -l` -gt 0 ]
                    then
                        echo "Removing old grid service files...";
                        rm -R /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war/*
                    else
                        echo "No previous files found.";
                 fi
                 mkdir /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war
                 tar -xvf lexEVS-wsrf.tar -C /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war
                 echo "Deployment complete.";
        fi
        if [ $ENV = "QA" ]
           then
                 echo "Deploying to QA...";
                 if [ `ls /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war | wc -l` -gt 0 ]
                    then
                        echo "Removing old grid service files...";
                        rm -R /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war/*
                    else
                        echo "No previous files found.";
                 fi
                 mkdir /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war
                 tar -xvf lexEVS-wsrf.tar -C /usr/local/jboss404/server/ncicb-59580/deploy/wsrf.war
                 echo "Deployment complete.";
        fi
        if [ $ENV = "PROD" ]
            then
                echo "TODO: Add deployment code for production.";
        fi
   else
         echo "Deplpyment to $ENV cancelled.";
fi

# Prompt user to deploy globus

if [ "$1" = "-q" ]
   then
        answer="Y"
   else
        echo "Deploy GLOBUS jars to $ENV? [Y/N] "; read answer;
fi

# Perform deployments

if [ $answer = "Y" -o $answer = "y" ]
   then
        if [ $ENV = "DEV" ]
           then
                 echo "Deploying Globus jars to DEV...";
                 tar -xvf gridservice-lib.tar -C /usr/local/jboss404/server/ncicb-59580/lib
                 echo "Deployment complete.";
        fi
        if [ $ENV = "QA" ]
           then
                 echo "Deploying Globus jars to QA...";
                 tar -xvf gridservice-lib.tar -C /usr/local/jboss404/server/ncicb-59580/lib
                 echo "Deployment complete.";
        fi
        if [ $ENV = "PROD" ]
            then
                echo "TODO: Add deployment code for production.";
        fi
fi
