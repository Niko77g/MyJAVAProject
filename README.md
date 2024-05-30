# Inventory Manager
Inventory Manager is a simple application created using Java and JAVAFX, which uses created scenes that contain individual functions and product customization options such as deleting, updating, modifying String format and also the ability to download the entire HashMap database to the device in the form of a .txt file. 

# WHY?
The origin of InventoryManager was to learn how to program in JavaFX and to expand my Java programming skills by creating a simple GUI application suitable for small businesses that want to have an overview of what products they have to offer. 

# Quick Start
The program can be cloned via GitHub please follow this procedure:
<div>1. For the best user experience, I recommend using the Intellj development environment.</div>
  https://www.jetbrains.com/idea/download/?section=windows
<div>2.Clone your project from my GitHub repository using this command in Intellij Idea under Git/Get from Version Control:</div>
   <command> <img width="301" alt="image" src="https://github.com/Niko77g/MyJAVAProject/assets/94113127/3bbd0440-15d9-4fcd-9597-f92a607f8753">

<div>3.After cloning my GitHub project, you need to install the JDK version openjdk-22, which can be installed directly in the Intellij development environment. </div>
<div>3.To run a JavaFX application you need to have JavaFX SDK version 21 installed </div>
  https://gluonhq.com/products/javafx/
<div>4.In intellj Idea go to File/ Project Structure/Libraries where you need to use the + button to add the extracted openjfx file and select the lib subor file and click apply button. </div>
  <img width="371" alt="image" src="https://github.com/Niko77g/MyJAVAProject/assets/94113127/65cc4277-b754-49b8-b5ec-71a478cea892">

<div>5.In order for JavaFX files to work properly, you also need to add VM options using the cmd command for windows: </div>
  https://openjfx.io/openjfx-docs/
  <div class="snippet-clipboard-content notranslate position-relative overflow-auto" data-snippet-clipboard-copy-content="Windows command: --module-path "\path\to\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml">
  <pre lang="terminal" class="notranslate"><code>Windows command: --module-path "\path\to\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml</code></pre>
</div>
  <strong>Attention:</strong> It is necessary to modify the command to the location where the javafx sdk is located
 
# USAGE 
<div>Lists of functions: </div>
<li><strong>Add function:</strong> Includes the ability to add a title, number of pieces, price and also the ability to select a default title size.</li>
<li><strong>Update function:</strong> On the basis of the created ID it is possible to update items such as name, number of pieces, price and default size of the name.</li>
<li><strong>Remove function:</strong> After entering the correct product ID it is possible to remove the product from the HashMap.</li>
<li><strong>Search function:</strong> Ability to search for a product based on ID with the option to download a .txt file with the entire HashMap database</li>
