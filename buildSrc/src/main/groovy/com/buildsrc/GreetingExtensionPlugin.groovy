package com.buildsrc

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingExtensionPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        // Add the 'greeting' extension object
        def extension = project.extensions.create('greetings', GreetingsExtension)

        // Add a task that uses configuration from the extension object
        project.tasks.create('task_buildSrc_greeting') {
            doLast {
                println "${extension.message} from ${extension.greeter}"
                println project.greetings
            }
        }
    }
}

class GreetingsExtension {
    String message
    String greeter
}