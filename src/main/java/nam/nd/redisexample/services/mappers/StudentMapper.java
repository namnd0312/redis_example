package nam.nd.redisexample.services.mappers;

import nam.nd.redisexample.dtos.StudentDto;
import nam.nd.redisexample.models.Student;
import nam.nd.redisexample.util.Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author nam.nd
 * @created 04/07/2021 - 9:25 PM
 */

@Component
public class StudentMapper {

    public Student toEntity(StudentDto dto) {

        if (dto == null) {
            return null;
        }

        Student entity = new Student();

        Util.trimStringValuesOfObject(dto);

        BeanUtils.copyProperties(dto, entity);

        if (!StringUtils.isEmpty(dto.getId())) {
            entity.setId(Util.stringToLong(dto.getId()));
        }

        if (!StringUtils.isEmpty(dto.getAge())) {
            entity.setAge(Util.stringToInteger(dto.getAge()));
        }


        if(!StringUtils.isEmpty(dto.getClassId())){
            entity.setClassId(Util.stringToLong(dto.getClassId()));
        }

        entity.setTimeUpdate(Instant.now());

        return entity;
    }


    public StudentDto toDto(Student entity) {

        if (entity == null) {
            return null;
        }

        Util.trimStringValuesOfObject(entity);

        StudentDto dto = new StudentDto();

        BeanUtils.copyProperties(entity, dto);

        if (entity.getId() != null) {
            dto.setId(Util.longToString(entity.getId()));
        }

        if (entity.getAge() != null) {
            dto.setAge(Util.integerToString(entity.getAge()));
        }

        if (entity.getClassId() != null) {
            dto.setClassId(Util.longToString(entity.getClassId()));
        }

        if (entity.getTimeUpdate() != null) {
            dto.setTimeUpdate(Util.instantToString(entity.getTimeUpdate()));
        }

        return dto;
    }
}
