package by.training.webapplication.service.command;

/**
 * Created by Tanya on 20.07.2016.
 */
public enum CommandEnum {
    LOGIN{
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT{
        {
           this.command = new LogoutCommand();
        }
    },
    REGISTRATION {
        {
            this.command = new RegCommand();
        }
    },
    EXPRESSIONLANGUAGE {
        {
            this.command = new ExprLangCommand();
        }
    },
    MAILTO {
        {
            this.command = new MailToCommand();
        }
    },
    VIEWPORTFOLIO{
        {
            this.command = new ViewPortfolioCommand();
        }
    },
    CALCULANDORDER{
        {
            this.command = new CalcAndOrderCommand();
        }
    },
    VIEWWORKINFO{
        {
            this.command = new WorkInfoCommand();
        }
    },
    VIEWMESSAGE{
        {
            this.command = new ViewMessageCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return command;
    }
}
