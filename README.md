# extension-renamer
Command Line tool to easily rename all extensions in a directory, and all of its subdirectories.

History: 

Basically I have been working on a project for a few years, and decided to switch templating engines from Handlebars to EJS. The project currently holds over 100+ different files. So as I was renaming them one by one, I decided "hey why not just create a tool for this and make it free/open source :D". 

Description: 

Currently this tool will search the directory given for all files with the extension given, and rename it to the extension you want. It can also be made recursive, so it will also search for all subdirectories as well. So if you have a large project and need to rename files, this is a very easy tool to use.

How to use: 

This tool takes 4 parameters

1) directory: "~/example/directory/of/current/project"
2) current extension: "hbs"
3) name of new extension: "ejs"
4) recursive: true

java -jar extension-renamer.jar directory currentExtension newExtension recursive


