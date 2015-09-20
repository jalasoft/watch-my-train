package cz.jalasoft.trainwatch.resources.observer;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
final class TrainObserverResourceAssembler {

    private final TrainObserver observer;
    private final TrainObserverResource resource;

    TrainObserverResourceAssembler(TrainObserver observer) {
        this.observer = observer;
        this.resource = new TrainObserverResource();
    }

    TrainObserverResource resource() {
        resource.setNickname(observer.nickname().value());
        return resource;
    }

    TrainObserverResourceAssembler withSelfLink() {
        resource.add(selfLink());
        return this;
    }

    private Link selfLink() {
        ControllerLinkBuilder selfLinkBuilder = linkTo(TrainObserverEndpoint.class).slash(observer.nickname());
        return selfLinkBuilder.withSelfRel();
    }


    TrainObserverResourceAssembler withRegisteredObserversLink() {
       resource.add(registeredObserversLink());
        return this;
    }

    private Link registeredObserversLink() {
        Link allLink = linkTo(methodOn(TrainObserverEndpoint.class).registeredObservers()).withRel("registered observers");
        return allLink;
    }

    TrainObserverResourceAssembler withUnregisterObserverLink() {
        resource.add(unregisterObserverLink());
        return this;
    }

    private Link unregisterObserverLink() {
        Link unregisterLink = linkTo(methodOn(TrainObserverEndpoint.class).unregisterObserver(observer.nickname().value())).withRel("unregister");
        return unregisterLink;
    }
}
