package cz.jalasoft.trainwatch.resources;

import cz.jalasoft.trainwatch.domain.model.observer.TrainObserver;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/6/15.
 */
final class ObserverAssembler {

    private final TrainObserver observer;
    private final ObserverResource resource;

    ObserverAssembler(TrainObserver observer) {
        this.observer = observer;
        this.resource = new ObserverResource();
    }

    ObserverResource resource() {
        resource.setNickname(observer.nickname());
        return resource;
    }

    ObserverAssembler withSelfLink() {
        resource.add(selfLink());
        return this;
    }

    private Link selfLink() {
        ControllerLinkBuilder selfLinkBuilder = linkTo(ObserverEndpoint.class).slash(observer.nickname());
        return selfLinkBuilder.withSelfRel();
    }


    ObserverAssembler withRegisteredObserversLink() {
       resource.add(registeredObserversLink());
        return this;
    }

    private Link registeredObserversLink() {
        Link allLink = linkTo(methodOn(ObserverEndpoint.class).registeredObservers()).withRel("registered observers");
        return allLink;
    }

    ObserverAssembler withUnregisterObserverLink() {
        resource.add(unregisterObserverLink());
        return this;
    }

    private Link unregisterObserverLink() {
        Link unregisterLink = linkTo(methodOn(ObserverEndpoint.class).unregisterObserver(observer.nickname())).withRel("unregister");
        return unregisterLink;
    }
}
