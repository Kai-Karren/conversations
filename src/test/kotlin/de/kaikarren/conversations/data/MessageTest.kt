package de.kaikarren.conversations.data

import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MessageTest {

    @Test
    fun testSimpleMessage() {

        val intent = Intent(
            name = "reservation_request",
            confidence = 0.81,
            classifier = "unit_test"
        )

        val message = Message(
            id = "1e84c925-09f5-41aa-a419-199ce06e0567",
            timestamp = "2023-08-07T12:51:44.582190600Z",
            participant = "John Doe",
            text = "I would like to make a reservation.",
            intents = mutableListOf(intent),
            intentRanking = mutableListOf(intent),
        )

        val gson = GsonBuilder().setPrettyPrinting().create()

        val conversationAsJSON = gson.toJson(message)

        val inputStream = this.javaClass.classLoader.getResourceAsStream("json/expected_message_representations/test_simple_message.json")

        Assertions.assertEquals(String(inputStream!!.readAllBytes()), conversationAsJSON)

    }
}