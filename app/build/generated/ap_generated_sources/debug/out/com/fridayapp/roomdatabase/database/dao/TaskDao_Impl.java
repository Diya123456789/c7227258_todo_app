package com.fridayapp.roomdatabase.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.fridayapp.roomdatabase.model.Task;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TaskDao_Impl implements TaskDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Task> __insertionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __deletionAdapterOfTask;

  private final EntityDeletionOrUpdateAdapter<Task> __updateAdapterOfTask;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCompletedTasks;

  public TaskDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTask = new EntityInsertionAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `task_table` (`date`,`time`,`id`,`title`,`description`,`priority_column`,`action`,`updated_on`,`item_check_status`,`alarm`) VALUES (?,?,nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.date == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.date);
        }
        if (value.time == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.time);
        }
        stmt.bindLong(3, value.id);
        if (value.title == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.description);
        }
        stmt.bindLong(6, value.priority);
        stmt.bindLong(7, value.getAction());
        if (value.getUpdatedOn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUpdatedOn());
        }
        final Integer _tmp;
        _tmp = value.getItem_check_status() == null ? null : (value.getItem_check_status() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp);
        }
        if (value.getAlarm() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAlarm());
        }
      }
    };
    this.__deletionAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `task_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfTask = new EntityDeletionOrUpdateAdapter<Task>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `task_table` SET `date` = ?,`time` = ?,`id` = ?,`title` = ?,`description` = ?,`priority_column` = ?,`action` = ?,`updated_on` = ?,`item_check_status` = ?,`alarm` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Task value) {
        if (value.date == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.date);
        }
        if (value.time == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.time);
        }
        stmt.bindLong(3, value.id);
        if (value.title == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.title);
        }
        if (value.description == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.description);
        }
        stmt.bindLong(6, value.priority);
        stmt.bindLong(7, value.getAction());
        if (value.getUpdatedOn() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUpdatedOn());
        }
        final Integer _tmp;
        _tmp = value.getItem_check_status() == null ? null : (value.getItem_check_status() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, _tmp);
        }
        if (value.getAlarm() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAlarm());
        }
        stmt.bindLong(11, value.id);
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM task_table";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCompletedTasks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM task_table WHERE `action` = 1";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTask.insert(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Task task) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTask.handle(task);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public void deleteCompletedTasks() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCompletedTasks.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCompletedTasks.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Task>> getAllTasks() {
    final String _sql = "SELECT * FROM task_table ORDER BY `action` DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> searchAllTask() {
    final String _sql = "SELECT * FROM task_table WHERE title";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> sortByPriorityASC() {
    final String _sql = "SELECT * FROM task_table ORDER BY priority_column ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> sortByTimeCreatedASC() {
    final String _sql = "SELECT * FROM task_table ORDER BY time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> highPriority() {
    final String _sql = "SELECT * FROM task_table WHERE priority_column = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> mediumPriority() {
    final String _sql = "SELECT * FROM task_table WHERE priority_column = 2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> lowPriority() {
    final String _sql = "SELECT * FROM task_table WHERE priority_column = 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> getPendingTask() {
    final String _sql = "SELECT * FROM task_table WHERE `action` = 2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<Task>> getCompletedTasks() {
    final String _sql = "SELECT * FROM task_table WHERE `action` = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"task_table"}, false, new Callable<List<Task>>() {
      @Override
      public List<Task> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority_column");
          final int _cursorIndexOfAction = CursorUtil.getColumnIndexOrThrow(_cursor, "action");
          final int _cursorIndexOfUpdatedOn = CursorUtil.getColumnIndexOrThrow(_cursor, "updated_on");
          final int _cursorIndexOfItemCheckStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "item_check_status");
          final int _cursorIndexOfAlarm = CursorUtil.getColumnIndexOrThrow(_cursor, "alarm");
          final List<Task> _result = new ArrayList<Task>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Task _item;
            _item = new Task();
            _item.date = _cursor.getString(_cursorIndexOfDate);
            _item.time = _cursor.getString(_cursorIndexOfTime);
            _item.id = _cursor.getInt(_cursorIndexOfId);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.priority = _cursor.getInt(_cursorIndexOfPriority);
            final int _tmpAction;
            _tmpAction = _cursor.getInt(_cursorIndexOfAction);
            _item.setAction(_tmpAction);
            final String _tmpUpdatedOn;
            _tmpUpdatedOn = _cursor.getString(_cursorIndexOfUpdatedOn);
            _item.setUpdatedOn(_tmpUpdatedOn);
            final Boolean _tmpItem_check_status;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfItemCheckStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfItemCheckStatus);
            }
            _tmpItem_check_status = _tmp == null ? null : _tmp != 0;
            _item.setItem_check_status(_tmpItem_check_status);
            final String _tmpAlarm;
            _tmpAlarm = _cursor.getString(_cursorIndexOfAlarm);
            _item.setAlarm(_tmpAlarm);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
