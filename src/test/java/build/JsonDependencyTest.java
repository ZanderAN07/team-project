package build;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** Verifies that JUnit discovers tests and Gson preserves JSON data. */
class JsonDependencyTest {
    @Test
    void roundTripPreservesTextAndNumbers() {
        final Gson gson = new Gson();
        final JsonObject original = new JsonObject();
        original.addProperty("name", "学生 \"Alex\"");
        original.addProperty("energy", 85);

        final JsonObject restored = gson.fromJson(gson.toJson(original), JsonObject.class);

        assertEquals(original.get("name").getAsString(), restored.get("name").getAsString());
        assertEquals(85, restored.get("energy").getAsInt());
    }
}
