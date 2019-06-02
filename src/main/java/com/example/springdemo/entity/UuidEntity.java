package com.example.springdemo.entity;

import com.example.springdemo.listener.UuidEntityListener;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Objects;
import java.util.UUID;

@Accessors(chain = true)
@Getter
@Setter
@MappedSuperclass
@EntityListeners(value = UuidEntityListener.class)
public class UuidEntity extends BaseEntity {
    private UUID uuid;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        UuidEntity that = (UuidEntity) object;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), uuid);
    }
}
