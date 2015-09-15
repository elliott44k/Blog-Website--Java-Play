package models.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.spi.SessionImplementor;
import play.db.jpa.GenericModel;
import play.db.jpa.Model;

@MappedSuperclass
public class BlogModel extends Model {

    @Id
    public Long id;
    
    public Long getId() {
        return id;
    }

    @Override
    public Object _key() {
        return getId();
    }

    
	public Serializable generateId(SessionImplementor session) {
		return null;
	}
	
	public boolean isNew() {
		return !isPersistent();
	}

	public String toString() {
		return getClass().getSimpleName() + ":" + id;
	}
}
