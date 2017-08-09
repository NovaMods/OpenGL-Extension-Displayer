import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_EXTENSIONS;
import static org.lwjgl.opengl.GL11.glGetString;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 * @author ddubois
 * @since 8/9/17.
 */
public class Driver {
    private static GLFWErrorCallback errorCallback = GLFWErrorCallback.createPrint(System.err);

    public static void main(String[] args) {
        glfwSetErrorCallback(errorCallback);

        if(!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        long window = glfwCreateWindow(640, 480, "Simple example", NULL, NULL);
        if (window == NULL) {
            glfwTerminate();
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwMakeContextCurrent(window);
        GL.createCapabilities();

        String extensions = glGetString(GL_EXTENSIONS);
        String[] extensionNames = extensions.split(" ");

        for(String s : extensionNames) {
            System.out.println(s);
        }
    }
}
