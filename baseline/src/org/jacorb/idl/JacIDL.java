/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.tools.ant.BuildException
 *  org.apache.tools.ant.DirectoryScanner
 *  org.apache.tools.ant.Task
 *  org.apache.tools.ant.taskdefs.MatchingTask
 *  org.apache.tools.ant.types.Environment$Variable
 *  org.apache.tools.ant.types.Path
 *  org.apache.tools.ant.util.FileNameMapper
 *  org.apache.tools.ant.util.GlobPatternMapper
 *  org.apache.tools.ant.util.SourceFileScanner
 */
package org.jacorb.idl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.apache.tools.ant.types.Environment;
import org.apache.tools.ant.types.Path;
import org.apache.tools.ant.util.FileNameMapper;
import org.apache.tools.ant.util.GlobPatternMapper;
import org.apache.tools.ant.util.SourceFileScanner;
import org.jacorb.idl.ConstDecl;
import org.jacorb.idl.Environment;
import org.jacorb.idl.GlobalInputStream;
import org.jacorb.idl.NameTable;
import org.jacorb.idl.ParseException;
import org.jacorb.idl.TypeMap;
import org.jacorb.idl.lexer;
import org.jacorb.idl.parser;

public class JacIDL
extends MatchingTask {
    private File _destdir;
    private File _srcdir;
    private Path _includepath;
    private int _debuglevel = 1;
    private boolean _generateir = false;
    private boolean _omgprefix;
    private boolean _generateincluded = false;
    private boolean _parseonly = false;
    private boolean _noskel = false;
    private boolean _nostub = false;
    private boolean _sloppyforward;
    private boolean _sloppynames;
    private boolean _nofinal = false;
    private boolean _ami_callback = false;
    private boolean _force_overwrite = false;
    private boolean _unchecked_narrow = false;
    private boolean _generateEnhanced;
    private boolean _generatediistubs = false;
    private List _defines = new ArrayList();
    private List _undefines = new ArrayList();
    private File[] _compileList = new File[0];
    private List _i2jpackages = new ArrayList();
    private I2JPackageTagHandler i2jHandler = new I2JPackageTagHandler();

    public JacIDL() {
        this._destdir = new File(".");
        this._srcdir = new File(".");
    }

    public void setDestdir(File file) {
        this._destdir = file;
    }

    public void setSrcdir(File file) {
        this._srcdir = file;
    }

    public void setIncludepath(Path path) {
        this._includepath = path;
    }

    public void setDebuglevel(int n) {
        this._debuglevel = n;
    }

    public void setGenerateir(boolean bl) {
        this._generateir = bl;
    }

    public void setOmgprefix(boolean bl) {
        this._omgprefix = bl;
    }

    public void setAll(boolean bl) {
        this._generateincluded = bl;
    }

    public void setParseonly(boolean bl) {
        this._parseonly = bl;
    }

    public void setNoskel(boolean bl) {
        this._noskel = bl;
    }

    public void setNostub(boolean bl) {
        this._nostub = bl;
    }

    public void setSloppyforward(boolean bl) {
        this._sloppyforward = bl;
    }

    public void setSloppynames(boolean bl) {
        this._sloppynames = bl;
    }

    public void setNofinal(boolean bl) {
        this._nofinal = bl;
    }

    public void setAmi_callback(boolean bl) {
        this._ami_callback = bl;
    }

    public void setForceOverwrite(boolean bl) {
        this._force_overwrite = bl;
    }

    public void setUncheckedNarrow(boolean bl) {
        this._unchecked_narrow = bl;
    }

    public void setGenerateEnhanced(boolean bl) {
        this._generateEnhanced = bl;
    }

    public void setGenerateDIIStubs(boolean bl) {
        this._generatediistubs = bl;
    }

    public void addDefine(Environment.Variable variable) {
        this._defines.add(variable);
    }

    public void addUndefine(Environment.Variable variable) {
        this._undefines.add(variable);
    }

    public I2JPackageTagHandler createI2jpackage() {
        return this.i2jHandler;
    }

    public void execute() throws BuildException {
        parser parser2 = null;
        parser.init();
        if (!this._destdir.exists()) {
            this._destdir.mkdirs();
        }
        parser.out_dir = this._destdir.getPath();
        parser.generateIncluded = this._generateincluded;
        parser.generateIR = this._generateir;
        parser.parse_only = this._parseonly;
        parser.generate_skeletons = !this._noskel;
        parser.generate_stubs = !this._nostub;
        parser.sloppy = this._sloppyforward;
        parser.strict_names = !this._sloppynames;
        parser.setGenerateFinalCode(!this._nofinal);
        parser.generate_ami_callback = this._ami_callback;
        parser.forceOverwrite = this._force_overwrite;
        parser.useUncheckedNarrow = this._unchecked_narrow;
        parser.generateEnhanced = this._generateEnhanced;
        parser.generateDiiStubs = this._generatediistubs;
        if (this._includepath != null) {
            String[] stringArray = this._includepath.list();
            for (int i = 0; i < stringArray.length; ++i) {
                File file = this.project.resolveFile(stringArray[i]);
                if (file.exists()) continue;
                throw new BuildException("include directory \"" + file.getPath() + "\" does not exist !", this.location);
            }
            GlobalInputStream.setIncludePath(this._includepath.toString());
        }
        if (this._omgprefix) {
            parser.package_prefix = "org.omg";
        }
        for (int i = 0; i < this._i2jpackages.size(); ++i) {
            parser.addI2JPackage((String)this._i2jpackages.get(i));
        }
        parser.getLogger().setPriority(Environment.intToPriority(this._debuglevel));
        this.resetFileLists();
        DirectoryScanner directoryScanner = this.getDirectoryScanner(this._srcdir);
        String[] stringArray = directoryScanner.getIncludedFiles();
        this.scanFiles(stringArray);
        try {
            if (this._compileList != null) {
                for (int i = 0; i < this._compileList.length; ++i) {
                    String string = this._compileList[i].getPath();
                    this.log("processing idl file: " + string);
                    GlobalInputStream.init();
                    GlobalInputStream.setInput(string);
                    lexer.reset();
                    NameTable.init();
                    ConstDecl.init();
                    TypeMap.init();
                    this.setupDefines();
                    parser2 = new parser();
                    parser2.parse();
                }
            }
        }
        catch (IOException iOException) {
            if (this._debuglevel >= 3) {
                iOException.printStackTrace();
            }
            throw new BuildException();
        }
        catch (ParseException parseException) {
            if (this._debuglevel >= 3) {
                parseException.printStackTrace();
            }
            throw new BuildException();
        }
        catch (Exception exception) {
            if (this._debuglevel >= 3) {
                exception.printStackTrace();
            }
            throw new BuildException();
        }
    }

    protected void resetFileLists() {
        this._compileList = new File[0];
    }

    protected void scanFiles(String[] stringArray) throws BuildException {
        GlobPatternMapper globPatternMapper = new GlobPatternMapper();
        globPatternMapper.setFrom("*.idl");
        globPatternMapper.setTo("*.java");
        SourceFileScanner sourceFileScanner = new SourceFileScanner((Task)this);
        File[] fileArray = sourceFileScanner.restrictAsFiles(stringArray, this._srcdir, this._destdir, (FileNameMapper)globPatternMapper);
        this._compileList = new File[fileArray.length];
        for (int i = 0; i < fileArray.length; ++i) {
            this.log("scan file: " + fileArray[i].getPath());
            File file = fileArray[i];
            if (!file.exists()) {
                throw new BuildException("The input file \"" + file.getPath() + "\" does not exist !");
            }
            this._compileList[i] = file;
        }
    }

    public File[] getFileList() {
        return this._compileList;
    }

    private void setupDefines() {
        Environment.Variable variable;
        int n;
        for (n = 0; n < this._defines.size(); ++n) {
            variable = (Environment.Variable)this._defines.get(n);
            String string = variable.getValue();
            if (string == null) {
                string = "1";
            }
            lexer.define(variable.getKey(), string);
        }
        for (n = 0; n < this._undefines.size(); ++n) {
            variable = (Environment.Variable)this._undefines.get(n);
            lexer.undefine(variable.getKey());
        }
    }

    public class I2JPackageTagHandler {
        public void setNames(String string) {
            JacIDL.this._i2jpackages.add(string);
        }
    }
}

