package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.Collection;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new ListCommand object
 */
public class ListCommandParser implements Parser<ListCommand>{

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns an ListCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListCommand parse(String args) throws ParseException {
        try {
            String trimmedArgs = args.trim();
            if(trimmedArgs.isEmpty()) {
               return new ListCommand(); 
            }

            //TODO: convert the string to collection to pass to parseTags
            
            Set<Tag> inputTag = ParserUtil.parseTags();
            return new ListCommand(trimmedArgs);
            
        } catch (IllegalArgumentException iae) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
        }
    }

}