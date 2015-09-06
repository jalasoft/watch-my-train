package cz.jalasoft.trainwatch.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
public class TrainObserverResource extends ResourceSupport {

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean hasNickname() {
        return nickname != null && !nickname.trim().isEmpty();
    }
}
