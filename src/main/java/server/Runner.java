package server;

import org.eclipse.jetty.server.Server;

import server.internal.HandlersBuilder;



/**
 * Runner for the Jetty server.
 * 
 * @author Danilo Queiroz - dpenna.queiroz@gmail.com
 */
public class Runner {

    protected Server server;
    private HandlersBuilder handlersBuilder;

    public Runner(HandlersBuilder handlersBuilder) {
        this.handlersBuilder = handlersBuilder;
        this.server = new Server(Configuration.getServerPort());
    }

    protected Runner(HandlersBuilder handlersBuilder, Server server) {
        this.handlersBuilder = handlersBuilder;
        this.server = server;
    }

    /**
     * Stops the running server
     * 
     * @throws Exception
     */
    public void stop() throws Exception {
        if (this.server.isRunning()) {
            this.server.stop();
        } else {
            throw new IllegalStateException("Server isn't running");
        }
    }

    /**
     * Starts the server
     */
    public void start() throws Exception {
        if (!this.server.isRunning()) {
            this.server.setHandler(this.handlersBuilder.createHandler());
            this.server.start();
        } else {
            throw new IllegalStateException("Server is already running");
        }
    }

    /**
     * Joins the server {@link Thread} and wait it die.
     */
    public void join() throws InterruptedException {
        this.server.join();
    }

    /*
     * Main method
     */
    public static void main(String[] args) throws Exception {
        HandlersBuilder handlersBuilder = new HandlersBuilder();
        Runner runner = new Runner(handlersBuilder);
        runner.start();
        runner.join();
    }
}
