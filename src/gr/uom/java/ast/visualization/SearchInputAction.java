package gr.uom.java.ast.visualization;

import java.util.ArrayList;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class SearchInputAction extends Action implements IWorkbenchAction {

	public static final String ID = "gr.uom.java.ast.visualiztion.SearchInputAction"; 



	public void run() {  

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();  
		String dialogBoxTitle = "Search";  
		String message = "Enter Class you would like to Search for: ";  
		String initialValue = "";


		InputDialog dialog = new InputDialog(shell, dialogBoxTitle, message, initialValue, null );
		if(dialog.open() == Window.OK){
			String value = dialog.getValue();
			if(value != null){
				ArrayList<PMClassFigure> classFigures = (ArrayList<PMClassFigure>) PackageMapDiagram.allClassFigures;
				
				for(PMClassFigure figure: classFigures){
					figure.setBackgroundColor(figure.getOriginalColor());
					if(figure.getName().toLowerCase().contains(value.toLowerCase())){
						figure.setBackgroundColor(ColorConstants.blue);
					}
				}
				
				
			}
		}
	}
  
public void dispose() {
	// TODO Auto-generated method stub

}

}
