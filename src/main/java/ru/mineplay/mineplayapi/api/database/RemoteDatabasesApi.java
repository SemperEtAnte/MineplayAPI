package ru.mineplay.mineplayapi.api.database;

import lombok.Getter;
import lombok.NonNull;
import ru.mineplay.mineplayapi.api.database.connection.HikariDatabaseConnection;
import ru.mineplay.mineplayapi.api.database.connection.MysqlDatabaseConnection;
import ru.mineplay.mineplayapi.api.database.connection.SqliteDatabaseConnection;
import ru.mineplay.mineplayapi.api.database.exception.RemoteDatabaseApiException;
import ru.mineplay.mineplayapi.api.database.interfaces.RemoteDatabaseSqlHandler;

import java.io.File;
import java.sql.SQLException;

public final class RemoteDatabasesApi {
    @Getter
    public static final RemoteDatabasesApi INSTANCE = new RemoteDatabasesApi();

    public @NonNull MysqlDatabaseConnection createMysqlConnection(@NonNull RemoteDatabaseConnectionFields connectionFields) {
        MysqlDatabaseConnection connectionHandler = new MysqlDatabaseConnection(connectionFields);
        connectionHandler.handleConnection();

        return connectionHandler;
    }

    public @NonNull HikariDatabaseConnection createHikariConnection(@NonNull RemoteDatabaseConnectionFields connectionFields) {
        HikariDatabaseConnection connectionHandler = new HikariDatabaseConnection(connectionFields);
        connectionHandler.handleConnection();

        return connectionHandler;
    }

    public @NonNull SqliteDatabaseConnection createSqliteConnection(@NonNull File sqliteFile) {
        SqliteDatabaseConnection connectionHandler = new SqliteDatabaseConnection(sqliteFile);
        connectionHandler.handleConnection();

        return connectionHandler;
    }


    public void checkArgument(boolean expression) {
        if (!expression) {
            throw new RemoteDatabaseApiException();
        }
    }

    public void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new RemoteDatabaseApiException(errorMessage);
        }
    }

    public void checkArgument(boolean expression, String errorMessage, Object... replacement) {
        if (!expression) {
            throw new RemoteDatabaseApiException(errorMessage, replacement);
        }
    }


    public void submitSqlExceptions(@NonNull RemoteDatabaseSqlHandler sqlHandler) {
        try {
            sqlHandler.handle();
        }

        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
