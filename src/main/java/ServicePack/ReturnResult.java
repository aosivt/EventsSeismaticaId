package ServicePack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by alex on 07.04.17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReturnResult {
    @JsonProperty("e")
    private final List<String> e;
    @JsonProperty("n")
    private final List<String> n;
    @JsonProperty("z")
    private final List<String> z;

    public ReturnResult(List<String> e,List<String> n,List<String> z) {
        this.e = e;
        this.n = n;
        this.z = z;
    }

    public List<String> getE() {
        return e;
    }

    public List<String> getN() {
        return n;
    }

    public List<String> getZ() {
        return z;
    }
}
