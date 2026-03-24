// Auto-generated CASE/UCO ontology class — do not edit manually.
package org.caseontology.uco.observable;

import java.util.ArrayList;
import java.util.List;
import org.caseontology.uco.core.UcoInherentCharacterizationThing;
import org.caseontology.uco.types.Hash;

/** An IExec action type is a grouping of characteristics unique to an action that executes a command-line operation on a Windows operating system. [based on https://docs.microsoft.com/en-us/windows/win32 */
public class IExecActionType extends UcoInherentCharacterizationThing {
    public static final String CLASS_IRI = "https://ontology.unifiedcyberontology.org/uco/observable/IExecActionType";
    public static final String NAMESPACE_PREFIX = "uco-observable";

    private String execArguments;
    private List<Hash> execProgramHashes;
    private String execProgramPath;
    private String execWorkingDirectory;

    public IExecActionType() {
        this.execProgramHashes = new ArrayList<>();
    }

    public String getExecArguments() { return this.execArguments; }
    public IExecActionType setExecArguments(String value) { this.execArguments = value; return this; }

    public List<Hash> getExecProgramHashes() { return this.execProgramHashes; }
    public IExecActionType setExecProgramHashes(List<Hash> value) { this.execProgramHashes = value; return this; }

    public String getExecProgramPath() { return this.execProgramPath; }
    public IExecActionType setExecProgramPath(String value) { this.execProgramPath = value; return this; }

    public String getExecWorkingDirectory() { return this.execWorkingDirectory; }
    public IExecActionType setExecWorkingDirectory(String value) { this.execWorkingDirectory = value; return this; }

}