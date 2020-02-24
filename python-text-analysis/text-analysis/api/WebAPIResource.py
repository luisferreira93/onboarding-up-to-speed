# importing flask module
from flask import Flask, request, Response, jsonify
from http import HTTPStatus
import spacy
import json


class Entity:
    text = None

    pos = None

    def __init__(self, text, pos):
        self.text = text

        self.pos = pos

# initializing a variable of Flask
app = Flask(__name__)


MIME_TYPE_JSON="application/json"


@app.route("/analyze/<text>", methods=['POST'])
def success(text):

    if request.method == 'POST':
        nlp = spacy.load("en_core_web_sm")
        doc = nlp(text)
        list_entities = []
        for token in doc:
            list_entities.append(Entity(text=token.text, pos=token.pos_).__dict__)
        return Response(json.dumps(list_entities), status=HTTPStatus.OK, mimetype=MIME_TYPE_JSON)
    else:
        return "Wrong"


if __name__ == "__main__":
    app.run()
