# BASE IMAGE
FROM python:3.7-alpine

# ENVIRONMENT
ENV PROJECT_FOLDER="text-analysis"
ENV PROJECT_SOURCE="text-analysis"

RUN set -x \
    && apk update \
    && apk --no-cache add \
        bash \
        libstdc++ \
    && apk --no-cache add --virtual .builddeps \
        build-base \
        openblas-dev \
        python3-dev

# Create project folder.
RUN mkdir -p /opt/$PROJECT_FOLDER

# Copy requirements.txt.
COPY requirements.txt /opt/$PROJECT_FOLDER/requirements.txt

# Installing requirements and dependencies.
RUN pip install -U -r /opt/$PROJECT_FOLDER/requirements.txt
RUN python -m spacy download en_core_web_sm

# Copy project source.
COPY $PROJECT_SOURCE /opt/$PROJECT_FOLDER/$PROJECT_SOURCE

WORKDIR /opt/$PROJECT_FOLDER

# EXPOSE
EXPOSE 8002

# ENTRYPOINT
CMD ["gunicorn", "-w", "1", "-b", "0.0.0.0:8002", "text-analysis.api.WebAPIResource:app"]