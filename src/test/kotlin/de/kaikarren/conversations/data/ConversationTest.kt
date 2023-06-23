package de.kaikarren.conversations.data

import com.google.gson.GsonBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConversationTest {

    @Test
    fun testConvertConversationToJSON() {

        val conversation = Conversation(
            id = "beb1b70a-cebf-4b7b-96d7-5757a551030d",
            participants = mutableListOf("John", "Jane"),
            messages = mutableListOf(
                Message(participant = "John", text = "How are you?", id = "85db4556-de22-4ccb-8344-8e96ba6be51f", timestamp = "2023-06-23T15:31:33.467416700Z"),
                Message(participant = "Jane", text = "I am fine. What's about you?", id = "fd4e6472-d1df-4e3d-8ecd-9e504af0821e", timestamp = "2023-06-23T15:31:33.467416700Z")
            ),
            timestamp = "2023-06-23T15:31:33.467416700Z",
        )

        val gson = GsonBuilder().setPrettyPrinting().create()

        val conversationAsJSON = gson.toJson(conversation)

        val inputStream = this.javaClass.classLoader.getResourceAsStream("expected_conversation_json_files/test_conversation_john_jane_01.json")

        assertEquals(String(inputStream!!.readAllBytes()), conversationAsJSON)

    }

}