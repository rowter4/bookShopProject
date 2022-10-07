package vttp2022.iss.book.backend.models;

import java.io.StringReader;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class AdminUser {
    public String userId;
    public String password;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


    public static AdminUser create(String json) {

        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject data = reader.readObject();

        final AdminUser user = new AdminUser();

        user.setUserId(data.getString("userId"));
        user.setPassword(data.getString("password"));

        return user;
    }

    public static AdminUser createSQL(SqlRowSet rs) {

		AdminUser user = new AdminUser();
		user.setUserId(rs.getString("username"));
        user.setPassword(rs.getString("password"));
		
		return user;
	}

    public JsonObject toJson() {
		return Json.createObjectBuilder()
			.add("username", userId)
			.build();
	}
}
