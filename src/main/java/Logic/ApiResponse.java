package Logic;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ApiResponse {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("error")
    private String error;

    @JsonProperty("restaurants")
    private List<RestaurantData> data;

    @JsonCreator
    public ApiResponse(@JsonProperty("success") boolean success,
                       @JsonProperty("error") String error,
                       @JsonProperty("restaurants") List<RestaurantData> data) {
        this.success=success;
        this.error=error;
        this.data =data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<RestaurantData> getData() {
        return data;
    }

    public void setData(List<RestaurantData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", error='" + error + '\'' +
                ", restaurants=" + data +
                '}';
    }

    public static class RestaurantData{
        @JsonProperty("id")
        private int id;

        @JsonProperty("name")
        private String name;
        @JsonProperty("score")
        private double score;
        @JsonProperty("address")
        private String address;



        public RestaurantData(@JsonProperty("id") int id,
                          @JsonProperty("name") String name,
                          @JsonProperty("score")double score,
                          @JsonProperty("address") String address) {
            this.id = id;
            this.name = name;
            this.score = score;
            this.address = address;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Restaurant{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

}
