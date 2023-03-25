package org.example.homework.commands;

import org.example.homework.exceptions.InvalidCommandParameterException;

import java.io.IOException;

public interface Command {
    void execute() throws IOException, InvalidCommandParameterException;
}
