#!/usr/bin/env bash

# Path to the virtual environment were we must install this package
VIRTUAL_ENVIRONMENT_PATH="venv"

# Import .env file environment variables
set -a
. ./.env
set +a

# Create the virtual environment
#python3 -m venv ${VIRTUAL_ENVIRONMENT_PATH} # Only update
python3 -m venv ${VIRTUAL_ENVIRONMENT_PATH} --clear # Always clear the environment first

# Activate a virtual environment
source ${VIRTUAL_ENVIRONMENT_PATH}/bin/activate


# Install latest pip
pip install --upgrade pip

save_path=$(pwd)

# Install the libraries/packages locally (for use on our system)
for val in ${RequiredLibrariesPaths[*]}; do
   echo $val
   cd $val
   pip install .
done

cd $save_path

# External libraries
pip install flask
pip install -U spacy
python -m spacy download en_core_web_sm


# Export all Python libraries installed on the current virtual environment
#pip freeze > requirements.txt
#pip install -r requirements.txt
pip freeze


# Deactivate a virtual environment
deactivate