package cz.jalasoft.trainwatch.resources.train;

import cz.jalasoft.trainwatch.domain.model.train.TrainName;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Honza Lastovicka (lastovicka@avast.com)
 * @since 9/9/15.
 */
final class TrainResourceAssembler {

    private final TrainName trainName;
    private final TrainResource resource;

    TrainResourceAssembler(TrainName trainName) {
        this.trainName = trainName;
        this.resource = new TrainResource();
    }

    TrainResource resource() {
        return resource;
    }

    TrainResourceAssembler withSelfLink() {
        resource.add(selfLink());
        return this;
    }

    private Link selfLink() {
        ControllerLinkBuilder selfLinkBuilder = linkTo(TrainEndpoint.class).slash(trainName.number());
        return selfLinkBuilder.withSelfRel();
    }
}
