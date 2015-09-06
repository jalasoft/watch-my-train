package cz.jalasoft.trainwatch.resources;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 8/24/15.
 */
public class ObserverResource extends ResourceSupport {

    private String nickname;

    public ObserverResource() {
        nickname="";
    }

    public ObserverResource(ObserverResource observer) {
        this.nickname = observer.getNickname();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
