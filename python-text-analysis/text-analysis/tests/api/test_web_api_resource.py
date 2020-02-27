import unittest

from api.WebAPIResource import app


SERVICE_SPACY_HOST = "127.0.0.1"
SERVICE_SPACY_PORT = "5000"
JSON_REQUEST={"sentence": "Hello, this is Luis from TDX"}
JSON_INVALID_REQUEST={"text": "Hello, this is Luis from TDX"}

URL_SERVICE_SPACY = "http://{}:{}/analyze".format(SERVICE_SPACY_HOST, SERVICE_SPACY_PORT)

class WebAPIResourceTest(unittest.TestCase):

    def test_service_spacy(self):
        print(URL_SERVICE_SPACY)
        with app.test_client() as c:
            response = c.post(URL_SERVICE_SPACY, json=JSON_REQUEST)
            print(response.data)
            self.assertEqual(response.status_code, 200)

    def test_ner_service_base(self):
        with app.test_client() as c:
            response = c.post(URL_SERVICE_SPACY, json=JSON_INVALID_REQUEST)
            self.assertEqual(response.status_code, 400)


if __name__ == "__main__":
    unittest.main()