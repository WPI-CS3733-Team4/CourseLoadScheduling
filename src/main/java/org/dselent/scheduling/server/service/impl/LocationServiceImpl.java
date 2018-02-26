package org.dselent.scheduling.server.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dselent.scheduling.server.dao.LocationsDao;
import org.dselent.scheduling.server.dto.LocationAddDto;
import org.dselent.scheduling.server.dto.LocationModifyDto;
import org.dselent.scheduling.server.dto.LocationRemoveDto;
import org.dselent.scheduling.server.model.Location;
import org.dselent.scheduling.server.service.LocationService;

import org.dselent.scheduling.server.sqlutils.QueryTerm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.dselent.scheduling.server.sqlutils.ComparisonOperator.EQUAL;
/**
 * Created by Nathan on 2/9/2018.
 */
@Service
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationsDao locationsDao;

    public LocationServiceImpl(){
    }
    @Transactional
    @Override
    public List<Integer> addLocation(LocationAddDto dto) throws SQLException {
        List<Integer> rowAffectedList = new ArrayList<>();

        Location location = new Location();

        location.setBuilding(dto.getBuilding());
        location.setRoom(dto.getRoom());
        location.setRoomSize(dto.getRoomSize());

        List<String> locationKeyHolderColumnNameList = new ArrayList<>();

        List<String> locationInsertColumnNameList = new ArrayList<>();


        locationInsertColumnNameList.add(Location.getColumnName(Location.Columns.BUILDING));
        locationInsertColumnNameList.add(Location.getColumnName(Location.Columns.ROOM));
        locationInsertColumnNameList.add(Location.getColumnName(Location.Columns.ROOM_SIZE));

        locationKeyHolderColumnNameList.add(Location.getColumnName(Location.Columns.ID));
        locationKeyHolderColumnNameList.add(Location.getColumnName(Location.Columns.CREATED_AT));
        locationKeyHolderColumnNameList.add(Location.getColumnName(Location.Columns.UPDATED_AT));

        rowAffectedList.add(locationsDao.insert(location, locationInsertColumnNameList, locationKeyHolderColumnNameList));

        return rowAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> modifyLocation(LocationModifyDto dto) throws SQLException{
        List<Integer> rowAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer locationId = dto.getLocationId();
        String locationBuilding = dto.getBuilding();
        Integer locationRoom = dto.getRoom();
        Integer locationRoomSize = dto.getRoomSize();

        queryTermList.add(new QueryTerm(Location.getColumnName(Location.Columns.ID),EQUAL,locationId,null));

        rowAffectedList.add(locationsDao.update(Location.getColumnName((Location.Columns.BUILDING)),locationBuilding,queryTermList));
        rowAffectedList.add(locationsDao.update(Location.getColumnName((Location.Columns.ROOM)),locationRoom,queryTermList));
        rowAffectedList.add(locationsDao.update(Location.getColumnName((Location.Columns.ROOM_SIZE)),locationRoomSize,queryTermList));

        return rowAffectedList;
    }

    @Transactional
    @Override
    public List<Integer> removeLocation(LocationRemoveDto dto) throws SQLException{
        List<Integer> rowAffectedList = new ArrayList<>();
        List<QueryTerm> queryTermList = new ArrayList<>();

        Integer locationId = dto.getLocationId();

        queryTermList.add(new QueryTerm(Location.getColumnName(Location.Columns.ID),EQUAL,locationId,null));

        rowAffectedList.add(locationsDao.delete(queryTermList));

        return rowAffectedList;
    }

    public List<Location> grabLocations() throws SQLException
    {
        List<QueryTerm> queryTermList = new ArrayList<>();

        List<String> columns = new ArrayList<>();
        columns.add(Location.getColumnName(Location.Columns.ID));
        columns.add(Location.getColumnName(Location.Columns.BUILDING));
        columns.add(Location.getColumnName(Location.Columns.ROOM));
        columns.add(Location.getColumnName(Location.Columns.ROOM_SIZE));
        columns.add(Location.getColumnName(Location.Columns.CREATED_AT));
        columns.add(Location.getColumnName(Location.Columns.UPDATED_AT));


        return locationsDao.select(columns, queryTermList, null);
    }

}