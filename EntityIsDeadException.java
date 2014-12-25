
/**
 *This is an exception that is thrown when an entity loses all of its hitpoints.
 *Depending upon which kind of entity this exception should be handled
 *differently. If the User is dead the gameover screen should appear. If any
 *other entity is dead then the entity should be destroyed.
 */
public class EntityIsDeadException extends Exception {
    public EntityIsDeadException(String message) {
        super(message);
    }
}
