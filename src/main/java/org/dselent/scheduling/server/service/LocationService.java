package org.dselent.scheduling.server.service;

import java.sql.SQLException;
import java.util.List;

import org.dselent.scheduling.server.dto.LocationAddDto;
import org.dselent.scheduling.server.dto.LocationModifyDto;
import org.dselent.scheduling.server.dto.LocationRemoveDto;
import org.dselent.scheduling.server.model.Location;
import org.springframework.stereotype.Service;

@Service
public interface LocationService
{
    public List<Integer> addLocation(LocationAddDto LocationAddDto) throws SQLException;
    public List<Integer> modifyLocation(LocationModifyDto LocationModifyDto) throws SQLException;
    public List<Integer> removeLocation(LocationRemoveDto LocationRemoveDto) throws SQLException;
    public List<Location> grabLocations() throws SQLException;
}
