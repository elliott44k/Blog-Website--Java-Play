package models.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.SessionImplementor;

import play.db.jpa.GenericModel;

@MappedSuperclass
public class BlogModel extends GenericModel {

    @Id
    @GeneratedValue(generator="BlogModelGenerator")
    @GenericGenerator(name="BlogModelGenerator",
    		strategy="blog.data.BlogModelIdGenerator",
    		parameters={
    		    @Parameter(name="sequence_name", value="hibernate_sequence"),
    		    @Parameter(name="increment_size", value="1")
    		})
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
