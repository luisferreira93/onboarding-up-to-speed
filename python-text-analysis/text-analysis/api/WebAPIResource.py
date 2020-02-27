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


@app.route("/analyze", methods=['POST'])
def success():
    print("entered")
    if request.method == 'POST':
        nlp = spacy.load("en_core_web_sm")
        data = request.json
        print(data)
        if "sentence" not in data:
            return Response("Wrong request received", status=HTTPStatus.BAD_REQUEST, mimetype=MIME_TYPE_JSON)
        doc = nlp(json.dumps(data['sentence']))
        list_entities = []
        for token in doc:
            if token.text is not "\"":
                list_entities.append(Entity(text=token.text, pos=token.pos_).__dict__)
        return Response(json.dumps(list_entities), status=HTTPStatus.OK, mimetype=MIME_TYPE_JSON)
    else:
        return "Wrong"


if __name__ == "__main__":
    app.run()
