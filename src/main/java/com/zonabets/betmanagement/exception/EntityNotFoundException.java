package com.zonabets.betmanagement.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in our records");
    }

    public EntityNotFoundException(Long bettorId, Long contestId, Class<?> entity) {
        super("The " + entity.getSimpleName().toLowerCase() + " with bettor ID '" + bettorId + "' and contest ID '"
                + contestId + "' does not exist in our records");
    }

}