package com.jorgeadammo.sistemas.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Classe base para indicar que se trata de uma entidade, nela temos os atributos
 * basicos para que a classe possa ser persistente.
 *
 */
@MappedSuperclass
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@EntityListeners(PersistentEntityListener.class)
public abstract class PersistentEntity implements IPersistentEntity<Long>, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Getter
    @Column(name = "id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "inclusion", nullable = false, updatable = false)
    protected Date inclusion;
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_edition", nullable = true)
    protected Date lastEdition;
    
    @Getter
    @Setter
    @Column(name = "included_by", length = 45, nullable = true)
    protected String includedBy;
    @Getter
    @Setter
    @Column(name = "edited_by", length = 45, nullable = true)
    protected String editedBy;

    /**
     * @return {@inheritDoc}
     */
    @Override
    public boolean isSaved() {
        return !(getId() == null || getId() == 0);
    }
    
    /**
     * @return a data de inclusao em formato string
     */
    public String getInclusionDateAsString() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(this.inclusion);
    }
    
    /**
     * @return a data de inclusao em localdate 
     */
    public LocalDate getInclusionAsLocalDate() {
        return this.inclusion.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInclusion() {
		return inclusion;
	}

	public void setInclusion(Date inclusion) {
		this.inclusion = inclusion;
	}

	public Date getLastEdition() {
		return lastEdition;
	}

	public void setLastEdition(Date lastEdition) {
		this.lastEdition = lastEdition;
	}

	public String getIncludedBy() {
		return includedBy;
	}

	public void setIncludedBy(String includedBy) {
		this.includedBy = includedBy;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((editedBy == null) ? 0 : editedBy.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((includedBy == null) ? 0 : includedBy.hashCode());
		result = prime * result + ((inclusion == null) ? 0 : inclusion.hashCode());
		result = prime * result + ((lastEdition == null) ? 0 : lastEdition.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersistentEntity other = (PersistentEntity) obj;
		if (editedBy == null) {
			if (other.editedBy != null)
				return false;
		} else if (!editedBy.equals(other.editedBy))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (includedBy == null) {
			if (other.includedBy != null)
				return false;
		} else if (!includedBy.equals(other.includedBy))
			return false;
		if (inclusion == null) {
			if (other.inclusion != null)
				return false;
		} else if (!inclusion.equals(other.inclusion))
			return false;
		if (lastEdition == null) {
			if (other.lastEdition != null)
				return false;
		} else if (!lastEdition.equals(other.lastEdition))
			return false;
		return true;
	}
}