# Conversations

Conversations is a Kotlin library that provides data classes to represent conversations with n participants. Participants can be humans or conversational user interfaces (CUIs).

## JSON Representation Example

```json
{
  "id": "beb1b70a-cebf-4b7b-96d7-5757a551030d",
  "timestamp": "2023-06-23T15:31:33.467416700Z",
  "participants": [
    "John Doe"
  ],
  "messages": [
    {
      "id": "1e84c925-09f5-41aa-a419-199ce06e0567",
      "participant": "John Doe",
      "text": "I would like to make a reservation.",
      "timestamp": "2023-08-07T12:51:44.582190600Z",
      "intents": [
        {
          "name": "reservation_request",
          "confidence": 0.81,
          "classifier": "unit_test"
        }
      ],
      "intent_ranking": [
        {
          "name": "reservation_request",
          "confidence": 0.81,
          "classifier": "unit_test"
        }
      ],
      "entities": [],
      "slots": [],
      "labels": []
    }
  ],
  "slots": [],
  "labels": []
}
```