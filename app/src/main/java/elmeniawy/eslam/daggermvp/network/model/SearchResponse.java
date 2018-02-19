package elmeniawy.eslam.daggermvp.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * SearchResponse
 * <p>
 * Created by Eslam El-Meniawy on 19-Feb-2018.
 * CITC - Mansoura University
 */

public class SearchResponse {
    private String status;

    @SerializedName("status_message")
    private String statusMessage;

    private Data data;

    //
    // Getters.
    //

    public String getStatus() {
        return status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public Data getData() {
        return data;
    }
}
