/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.filemaker.jwpc.common.DataObject
 */
package com.filemaker.jwpc.fmwp.datatype;

import com.filemaker.jwpc.common.DataObject;
import java.util.HashMap;

public enum ErrorCode {
    None(0),
    InternalError(-1),
    UserAbort(1),
    OutOfMemory(2),
    UnavailableCommand(3),
    UnknownCommand(4),
    InvalidCommand(5),
    ReadOnlyFile(6),
    OutOfStack(7),
    Empty(8),
    AccessDenied(9),
    DataMissing(10),
    InvalidName(11),
    NotUniqueName(12),
    HasReferences(13),
    OutOfRange(14),
    DivideByZero(15),
    RetryError(16),
    InvalidCharacterSet(17),
    LoginRequired(18),
    NotASCIIAlphaNumeric(19),
    CanceledByScript(20),
    LDAP_InvalidCredentials(49),
    LDAP_UnAvailable(52),
    LDAP_ServerDown(81),
    FileMissing(100),
    RecordMissing(101),
    FieldMissing(102),
    RelationMissing(103),
    ScriptMissing(104),
    LayoutMissing(105),
    TableMissing(106),
    IndexMissing(107),
    ValueListMissing(108),
    PrivilegesMissing(109),
    RelatedTablesMissing(110),
    InvalidRepetition(111),
    WindowMissing(112),
    FunctionMissing(113),
    FileReferenceMissing(114),
    MenuSetMissing(115),
    LayoutObjectMissing(116),
    DataSourceMissing(117),
    CoreComponentMissing(130),
    LanguageComponentMissing(131),
    NoRecordAccess(200),
    NoFieldWriteAccess(201),
    NoFieldReadAccess(202),
    NoPrintAccess(203),
    NoSortAccess(204),
    NoImportAccess(205),
    NoPasswordChangeAccess(206),
    NoSchemaChangeAccess(207),
    MinPasswordLength(208),
    DuplicatePassword(209),
    UserAccountDisabled(210),
    PasswordExpired(211),
    InvalidUserAccount(212),
    InvalidPassword(213),
    TooManyInvalidAttempts(214),
    CannotDuplicateGuest(216),
    NotAllowedOnAdministrator(217),
    UserIsUnlicensed(219),
    FileLocked(300),
    RecordLocked(301),
    TableLocked(302),
    SchemaLocked(303),
    LayoutLocked(304),
    ModIdDoesNotMatch(306),
    EmptyQuery(400),
    NoRecordsFound(401),
    NoDependentLookup(402),
    MaxDemoLimit(403),
    InvalidSort(404),
    InvalidOmit(405),
    InvalidReplace(406),
    InvalidRelation(407),
    InvalidDataType(408),
    InvalidRecover(412),
    InvalidFieldType(413),
    InvalidLayout(414),
    RelatedRecordRequired(415),
    PrimaryKeyRequired(416),
    UnsupportedESSDataSource(417),
    InvalidDate(500),
    InvalidTime(501),
    InvalidNumber(502),
    ValueOutOfRange(503),
    NotUniqueValue(504),
    NotExistingValue(505),
    NotMemberValue(506),
    NotValidValue(507),
    InvalidQueryValue(508),
    MissingRequiredValue(509),
    MissingJoinValue(510),
    ExceedsMaximumLength(511),
    RecordAlreadyModified(512),
    ExceedsTheoreticalMaxLength(513),
    PrintContainerPDFErrorNotContainer(604),
    PrintContainerPDFErrorEmpty(605),
    PrintContainerPDFErrorUnsupportedType(606),
    PrintContainerPDFErrorPasswordRequired(607),
    PrintContainerPDFErrorPrintingNotAllowed(608),
    WrongImportFileType(700),
    TranslatorMissing(711),
    InsufficientPrivileges(714),
    ExcelMissingElement(715),
    ProhibitedSQLCommand(716),
    IncompleteProfile(717),
    XMLParserError(718),
    XSLTransformError(719),
    RepeatingFieldsNotSupported(720),
    XMLXSLExceptionError(721),
    ImportTargetHasNoFields(722),
    ImportNoTablePermissions(723),
    ImportNoCreatePermission(724),
    ImportNoEditPermission(725),
    ImportMoreSourceThanTarget(726),
    ImportMoreTargetThanSource(727),
    ImportRecordsFailed(729),
    UnsupportedExcelFileType(730),
    ImportSameTableError(733),
    NotAPicture(734),
    Err_DataTruncated(736),
    CannotCreateFile(800),
    CannotCreateTempFile(801),
    CannotOpenFile(802),
    CannotOpenFileInUse(803),
    CannotOpenAsReadOnly(804),
    CannotOpenDamagedFile(805),
    CannotOpenWithThisVersion(806),
    CannotOpenUnrecognizableFile(807),
    DamagedAccessPrivileges(808),
    DiskFull(809),
    DiskLocked(810),
    OpenTemporaryFile(811),
    ExceedsHostCapacity(812),
    LockSynchronization(813),
    TooManyFilesOpen(814),
    NestedOpenFailed(815),
    CannotConvertFile(816),
    CannotOpenWrongBindingKey(817),
    CannotCopyRemote(819),
    FileIsClosing(820),
    DisconnectedFromHost(821),
    FMIFileNotFound(822),
    NetworkGuestsConnected(823),
    FileIsDamaged(824),
    InvalidPDFFileID(829),
    InvalidPDFFile(830),
    InvalidPDFPassword(831),
    PDFPagesModifyNotAllowed(832),
    PDFFileAlreadyOpen(833),
    SetLLMAccountEndpointMissingError(875),
    CannotFindTblInLayoutError(876),
    CannotFindLLMAccountError(877),
    LLMRequestOptionsJSONFormatParseError(878),
    LLMRequestParametersJSONFormatParseError(879),
    LLMEmbeddingInvalidRequestError(880),
    LLMEmbeddingError(881),
    LLMExtendedError(882),
    LLMRepetitionFieldsNotSupported(883),
    LLMOtherLLMExtendError(884),
    LLMOtherLLMEndpointError(885),
    LLMInvalidRequest(886),
    LLMClarisRAGSpaceError(887),
    LLMTrainInvalidAlgorithmError(888),
    LLMTrainInvalidParameterError(889),
    kLLMTemplateNotFoundError(890),
    kLLMTemplateModelMismatchError(891),
    kCannotFindLLMClarisRAGAccountError(892),
    kLLMFineTuneFailedJSONLFileError(893),
    UnsupportedXMLGrammar(954),
    NoDatabaseName(955),
    MaxDBSessionsExceeded(956),
    ConflictingCommands(957),
    ParameterMissing(958),
    TechnologyDisabled(959),
    InvalidParameter(960),
    UnsupportedScriptConfig(961),
    WPE_NoFMHostAvailable(1100),
    WPE_IPAccessRestricted(1101),
    WPE_BadPasscode(1102),
    WPE_MaxNumberOfWebEngines(1103),
    ParseError(1200),
    CalcTooFewParams(1201),
    CalcTooManyParams(1202),
    CalcUnexpectedEnd(1203),
    CalcUnexpectedToken(1204),
    CalcUnterminatedCmmt(1205),
    CalcUnterminatedString(1206),
    CalcUnbalancedParen(1207),
    CalcUnknownFunction(1208),
    CalcUnknownName(1209),
    CalcAlreadyRegistered(1210),
    CalcListUsage(1211),
    CalcOperatorMissing(1212),
    CalcVariableNotUnique(1213),
    CalcExpectedFieldOnly(1214),
    CalcInvalidGetFlag(1215),
    CalcSummaryFieldOnly(1216),
    CalcInvalidBreakField(1217),
    CalcBadFmt(1218),
    CalcCircularFormula(1219),
    CalcInvalidSummarizedFieldType(1220),
    CalcInvalidSummarizedDataType(1221),
    CalcCannotBeStored(1222),
    CalcUnimplemented(1223),
    CalcUndefined(1224),
    CalcFunctionNotSupported(1225),
    PoorName(1300),
    ODBCComponentsNotInstalled(1400),
    ODBCFailedToAllocateEnvironment(1401),
    ODBCFailedToFreeEnvironment(1402),
    ODBCFailedToDisconnect(1403),
    ODBCFailedToAllocateConnection(1404),
    ODBCFailedToFreeConnection(1405),
    ODBCFailedCheckForSQLAPI(1406),
    ODBCFailedToAllocateStatement(1407),
    ODBCExtendedError(1408),
    ODBCErrorNoInfo(1409),
    ODBCCommLinkError(1413),
    NoPHPPrivileges(1450),
    MustBeRemoteFile(1451),
    ScriptRunning(1452),
    SMTPAuthenticationFailed(1501),
    SMTPConnectionRefused(1502),
    SMTPSSLError(1503),
    SMTPEncryptionRequired(1504),
    SMTPAuthenticationNotSupported(1505),
    SMTPEmailSendFailed(1506),
    SMTPLoginError(1507),
    OAuthRequestAccessTokenFailed(1542),
    OAuthSendMailFailed(1543),
    PluginFailedToInit(1550),
    PluginCantInstall(1551),
    URLConnectionUnsupportedProtocol(1626),
    URLConnectionAuthenticationFalied(1627),
    URLConnectionSSLError(1628),
    URLConnectionTimeout(1629),
    URLConnectionMalformat(1630),
    URLConnectionGeneralFail(1631),
    URLConnectionSSLCertificateExpired(1632),
    URLConnectionSSLCertificateSelfSigned(1633),
    URLConnectionSSLCertificateVerificationError(1634),
    BlockNewUsers(1638),
    ODBCDataSourceUsageError(2045),
    QuickFindNoRecordsFound(2052),
    QuickFindEmptyQuery(2053),
    QuickFindNoFieldsEnabled(2054),
    NonIndexableFieldClient(2055),
    SemanticFindNoRecordsFound(2062),
    LLMFindNoFieldsEnabled(2068),
    ScriptTriggered(3000),
    WarnRevertRecord(3300),
    WarnRevertRequest(3301),
    WarnDeleteFoundSet(3302),
    WarnDeleteAll(3303),
    WarnDeleteRecord(3304),
    WarnDeleteRelatedRecord(3305),
    WarnFindMode(3306),
    WarnRelookup(3307),
    WarnReplaceAll(3308),
    WarnCommitRecord(3310),
    WarnLayoutChange(3311),
    ObjectLocked(3312),
    ScriptLocked(3313),
    ScriptLockedByCatalog(3314),
    ScriptsLocked(3315),
    SortOrderChanged(3356),
    Err_MustHaveFieldSelected(4100),
    Err_PlugInExceptionCaught(4101),
    Warn_LibraryObjectExists(4102),
    ODBCNothingToDisconnect(4506),
    ODBCMissingUserPassword(4507),
    ODBCErrorNoData(4508),
    LockNotPresent(8000),
    LockMustWait(8001),
    LockCanceled(8002),
    LockConflict(8003),
    LockSchemaNotSynced(8005),
    LockInvalidUpgradeType(8006),
    WarningPoorName(8200),
    JoinGraphCycle(8201),
    InvalidSelfJoin(8202),
    InvalidJoinFields(8203),
    TooManyTables(8204),
    CircularValueListDef(8205),
    NonIndexableField(8206),
    IndexRequired(8207),
    CannotChangeFieldType(8208),
    SelectFieldfromEachList(8209),
    FieldUsedInPrivileges(8210),
    NeedToRebuildDependecies(8211),
    SyncShadowFieldDupName(8212),
    InvalidTempTableUsage(8300),
    NonMatchingColumns(8301),
    InvalidTable(8302),
    InvalidScalarQuery(8303),
    DdlDuringOpenTransaction(8304),
    IndexAlreadyExists(8305),
    NoExternalSchemaChange(8306),
    CannotLockForUpdate(8307),
    ContinueAuthentication(8400),
    HasUserAccounts(8401),
    CannotDuplicateAdministrator(8402),
    InvalidCreatePrivileges(8403),
    CallbackScriptFailed(8407),
    FirstServerError(10000),
    LastServerError(19999),
    EventNoReply(10000),
    EventInvalidParam(10001),
    EventTimedOut(10002),
    HelperUnavailable(10003),
    ServerUnavailable(10004),
    DependencyMissing(10005),
    ServiceAlreadyRunning(10006),
    ObjectNotExist(10007),
    InvalidObjectType(10008),
    ObjectAlreadyExists(10009),
    ComponentIncompatible(10010),
    ServerIncompatible(10011),
    NotEnoughSpace(10012),
    HostUnreachable(10502),
    HostIncompatibleVersion(10503),
    CannotDisconnectAdmin(10504),
    ScheduleMissing(10600),
    ScheduleBadConfiguration(10601),
    ScheduleCreationError(10603),
    ScheduleCannotBeEnabled(10604),
    ScheduleBadTarget(10605),
    ScheduleBadBackupDest(10606),
    ScheduleBadScriptTarget(10607),
    ScheduleInvalidAccount(10608),
    BackupDestNoPermission(10700),
    BackupDestNotFolder(10701),
    BackupDestDiskFull(10702),
    BackupVerifyFailed(10703),
    ResourceNotFound(10800),
    LocaleNotFound(10801),
    EngineOffline(10900),
    EngineTooManyOpenFiles(10901),
    EngineFileNotOpen(10902),
    EngineFileSameNameOpen(10903),
    EngineNoFilesForOperation(10904),
    WPEValidURLGood(10905),
    NamedScriptMissing(10906),
    ScriptMakerAborted(10907),
    SystemScriptAborted(10908),
    SystemScriptReturnedNonZero(10909),
    FmsInvalidCommand(11000),
    InvalidOption(11001),
    CommandMissing(11002),
    UserRejectedConfirmation(11003),
    DisconnectGuestInvalidCommand(11004),
    DisconnectGuestInvalidClientID(11005),
    WPEAlreadyRunning(11200),
    WPEAlreadyStopping(11201),
    WPEInitFailure(11202),
    InvalidSessionID(11203),
    InvalidAuthentication(11204),
    InvalidRequestForCurrentContext(11205),
    CannotReadStream(20000),
    NoStyleRuns(20010),
    StyleNotFound(20011),
    CannotReadStyles(20012),
    CannotWriteStyles(20013),
    BufferIsFull(20100),
    NoStream(20101),
    UnicodeInternal(20200),
    UnicodeBufferTooSmall(20201),
    CannotSet(20300),
    UnicodeConversionError(20301),
    UnknownUniversalPathType(20302),
    Cancelled(20400),
    EndOfFile(20401),
    Permission(20402),
    Specification(20403),
    FileNotOpen(20404),
    FileNotFound(20405),
    FileExists(20406),
    AlreadyOpen(20407),
    Read(20408),
    Write(20409),
    IO(20410),
    AsyncNotAllowed(20411),
    ForkNotFound(20412),
    DirectoryNotFound(20500),
    DirectoryNotEmpty(20501),
    NetInitializationErr(20600),
    NetCannotHostErr(20601),
    NetConnectionErr(20602),
    NetCommunicationsErr(20603),
    InstallCodeConflict(20604),
    PostNetCommunicationsErr(20610),
    AppleIdNotFoundErrorStrID(20801),
    AppleIdPasscodeNotFoundErrorStrID(20802),
    AppleIdPasscodeExpireErrorStrID(20803),
    InvalidAppleIdTypeAccountErrorStrID(20804),
    InvalidEmailFormatError(20805),
    SendPasscodeEmailFailedError(20806),
    AppleIdAccountDisabledErrorStrID(20810);

    protected static HashMap<Integer, ErrorCode> objMap;
    protected int mErrorCode;
    protected String mErrorText;

    private ErrorCode(int n2) {
        this.mErrorCode = n2;
    }

    public boolean ok() {
        return this.mErrorCode == ErrorCode.None.mErrorCode;
    }

    public int getErrorCode() {
        int n = this.mErrorCode;
        switch (this.ordinal()) {
            case 247: 
            case 249: 
            case 251: {
                n = ErrorCode.NoRecordsFound.mErrorCode;
                break;
            }
            case 248: {
                n = ErrorCode.EmptyQuery.mErrorCode;
            }
        }
        return n;
    }

    public static ErrorCode fromValue(int n) {
        ErrorCode errorCode = objMap.get(n);
        if (errorCode == null) {
            errorCode = InternalError;
        }
        return errorCode;
    }

    public static boolean hasError(int n) {
        return n != None.getErrorCode();
    }

    public boolean isAuthenticationError() {
        return this.mErrorCode == InvalidAuthentication.getErrorCode();
    }

    public String toString() {
        return DataObject.toString((Object)((Object)this));
    }

    static {
        objMap = new HashMap();
        objMap.put(ErrorCode.None.mErrorCode, None);
        objMap.put(ErrorCode.InternalError.mErrorCode, InternalError);
        objMap.put(ErrorCode.UserAbort.mErrorCode, UserAbort);
        objMap.put(ErrorCode.OutOfMemory.mErrorCode, OutOfMemory);
        objMap.put(ErrorCode.UnavailableCommand.mErrorCode, UnavailableCommand);
        objMap.put(ErrorCode.UnknownCommand.mErrorCode, UnknownCommand);
        objMap.put(ErrorCode.InvalidCommand.mErrorCode, InvalidCommand);
        objMap.put(ErrorCode.ReadOnlyFile.mErrorCode, ReadOnlyFile);
        objMap.put(ErrorCode.OutOfStack.mErrorCode, OutOfStack);
        objMap.put(ErrorCode.Empty.mErrorCode, Empty);
        objMap.put(ErrorCode.AccessDenied.mErrorCode, AccessDenied);
        objMap.put(ErrorCode.DataMissing.mErrorCode, DataMissing);
        objMap.put(ErrorCode.InvalidName.mErrorCode, InvalidName);
        objMap.put(ErrorCode.NotUniqueName.mErrorCode, NotUniqueName);
        objMap.put(ErrorCode.HasReferences.mErrorCode, HasReferences);
        objMap.put(ErrorCode.OutOfRange.mErrorCode, OutOfRange);
        objMap.put(ErrorCode.DivideByZero.mErrorCode, DivideByZero);
        objMap.put(ErrorCode.RetryError.mErrorCode, RetryError);
        objMap.put(ErrorCode.InvalidCharacterSet.mErrorCode, InvalidCharacterSet);
        objMap.put(ErrorCode.LoginRequired.mErrorCode, LoginRequired);
        objMap.put(ErrorCode.NotASCIIAlphaNumeric.mErrorCode, NotASCIIAlphaNumeric);
        objMap.put(ErrorCode.CanceledByScript.mErrorCode, CanceledByScript);
        objMap.put(ErrorCode.LDAP_UnAvailable.mErrorCode, LDAP_UnAvailable);
        objMap.put(ErrorCode.LDAP_InvalidCredentials.mErrorCode, LDAP_InvalidCredentials);
        objMap.put(ErrorCode.LDAP_ServerDown.mErrorCode, LDAP_ServerDown);
        objMap.put(ErrorCode.FileMissing.mErrorCode, FileMissing);
        objMap.put(ErrorCode.RecordMissing.mErrorCode, RecordMissing);
        objMap.put(ErrorCode.FieldMissing.mErrorCode, FieldMissing);
        objMap.put(ErrorCode.RelationMissing.mErrorCode, RelationMissing);
        objMap.put(ErrorCode.ScriptMissing.mErrorCode, ScriptMissing);
        objMap.put(ErrorCode.LayoutMissing.mErrorCode, LayoutMissing);
        objMap.put(ErrorCode.TableMissing.mErrorCode, TableMissing);
        objMap.put(ErrorCode.IndexMissing.mErrorCode, IndexMissing);
        objMap.put(ErrorCode.ValueListMissing.mErrorCode, ValueListMissing);
        objMap.put(ErrorCode.PrivilegesMissing.mErrorCode, PrivilegesMissing);
        objMap.put(ErrorCode.RelatedTablesMissing.mErrorCode, RelatedTablesMissing);
        objMap.put(ErrorCode.InvalidRepetition.mErrorCode, InvalidRepetition);
        objMap.put(ErrorCode.WindowMissing.mErrorCode, WindowMissing);
        objMap.put(ErrorCode.FunctionMissing.mErrorCode, FunctionMissing);
        objMap.put(ErrorCode.FileReferenceMissing.mErrorCode, FileReferenceMissing);
        objMap.put(ErrorCode.MenuSetMissing.mErrorCode, MenuSetMissing);
        objMap.put(ErrorCode.LayoutObjectMissing.mErrorCode, LayoutObjectMissing);
        objMap.put(ErrorCode.DataSourceMissing.mErrorCode, DataSourceMissing);
        objMap.put(ErrorCode.CoreComponentMissing.mErrorCode, CoreComponentMissing);
        objMap.put(ErrorCode.LanguageComponentMissing.mErrorCode, LanguageComponentMissing);
        objMap.put(ErrorCode.NoRecordAccess.mErrorCode, NoRecordAccess);
        objMap.put(ErrorCode.NoFieldWriteAccess.mErrorCode, NoFieldWriteAccess);
        objMap.put(ErrorCode.NoFieldReadAccess.mErrorCode, NoFieldReadAccess);
        objMap.put(ErrorCode.NoPrintAccess.mErrorCode, NoPrintAccess);
        objMap.put(ErrorCode.NoSortAccess.mErrorCode, NoSortAccess);
        objMap.put(ErrorCode.NoImportAccess.mErrorCode, NoImportAccess);
        objMap.put(ErrorCode.NoPasswordChangeAccess.mErrorCode, NoPasswordChangeAccess);
        objMap.put(ErrorCode.NoSchemaChangeAccess.mErrorCode, NoSchemaChangeAccess);
        objMap.put(ErrorCode.MinPasswordLength.mErrorCode, MinPasswordLength);
        objMap.put(ErrorCode.DuplicatePassword.mErrorCode, DuplicatePassword);
        objMap.put(ErrorCode.UserAccountDisabled.mErrorCode, UserAccountDisabled);
        objMap.put(ErrorCode.PasswordExpired.mErrorCode, PasswordExpired);
        objMap.put(ErrorCode.InvalidUserAccount.mErrorCode, InvalidUserAccount);
        objMap.put(ErrorCode.InvalidPassword.mErrorCode, InvalidPassword);
        objMap.put(ErrorCode.TooManyInvalidAttempts.mErrorCode, TooManyInvalidAttempts);
        objMap.put(ErrorCode.CannotDuplicateGuest.mErrorCode, CannotDuplicateGuest);
        objMap.put(ErrorCode.NotAllowedOnAdministrator.mErrorCode, NotAllowedOnAdministrator);
        objMap.put(ErrorCode.UserIsUnlicensed.mErrorCode, UserIsUnlicensed);
        objMap.put(ErrorCode.AppleIdNotFoundErrorStrID.mErrorCode, AppleIdNotFoundErrorStrID);
        objMap.put(ErrorCode.AppleIdPasscodeNotFoundErrorStrID.mErrorCode, AppleIdPasscodeNotFoundErrorStrID);
        objMap.put(ErrorCode.AppleIdPasscodeExpireErrorStrID.mErrorCode, AppleIdPasscodeExpireErrorStrID);
        objMap.put(ErrorCode.InvalidAppleIdTypeAccountErrorStrID.mErrorCode, InvalidAppleIdTypeAccountErrorStrID);
        objMap.put(ErrorCode.SendPasscodeEmailFailedError.mErrorCode, SendPasscodeEmailFailedError);
        objMap.put(ErrorCode.AppleIdAccountDisabledErrorStrID.mErrorCode, AppleIdAccountDisabledErrorStrID);
        objMap.put(ErrorCode.FileLocked.mErrorCode, FileLocked);
        objMap.put(ErrorCode.RecordLocked.mErrorCode, RecordLocked);
        objMap.put(ErrorCode.TableLocked.mErrorCode, TableLocked);
        objMap.put(ErrorCode.SchemaLocked.mErrorCode, SchemaLocked);
        objMap.put(ErrorCode.LayoutLocked.mErrorCode, LayoutLocked);
        objMap.put(ErrorCode.ModIdDoesNotMatch.mErrorCode, ModIdDoesNotMatch);
        objMap.put(ErrorCode.EmptyQuery.mErrorCode, EmptyQuery);
        objMap.put(ErrorCode.NoRecordsFound.mErrorCode, NoRecordsFound);
        objMap.put(ErrorCode.NoDependentLookup.mErrorCode, NoDependentLookup);
        objMap.put(ErrorCode.MaxDemoLimit.mErrorCode, MaxDemoLimit);
        objMap.put(ErrorCode.InvalidSort.mErrorCode, InvalidSort);
        objMap.put(ErrorCode.InvalidOmit.mErrorCode, InvalidOmit);
        objMap.put(ErrorCode.InvalidReplace.mErrorCode, InvalidReplace);
        objMap.put(ErrorCode.InvalidRelation.mErrorCode, InvalidRelation);
        objMap.put(ErrorCode.InvalidDataType.mErrorCode, InvalidDataType);
        objMap.put(ErrorCode.InvalidRecover.mErrorCode, InvalidRecover);
        objMap.put(ErrorCode.InvalidFieldType.mErrorCode, InvalidFieldType);
        objMap.put(ErrorCode.InvalidLayout.mErrorCode, InvalidLayout);
        objMap.put(ErrorCode.RelatedRecordRequired.mErrorCode, RelatedRecordRequired);
        objMap.put(ErrorCode.PrimaryKeyRequired.mErrorCode, PrimaryKeyRequired);
        objMap.put(ErrorCode.UnsupportedESSDataSource.mErrorCode, UnsupportedESSDataSource);
        objMap.put(ErrorCode.InvalidDate.mErrorCode, InvalidDate);
        objMap.put(ErrorCode.InvalidTime.mErrorCode, InvalidTime);
        objMap.put(ErrorCode.InvalidNumber.mErrorCode, InvalidNumber);
        objMap.put(ErrorCode.ValueOutOfRange.mErrorCode, ValueOutOfRange);
        objMap.put(ErrorCode.NotUniqueValue.mErrorCode, NotUniqueValue);
        objMap.put(ErrorCode.NotExistingValue.mErrorCode, NotExistingValue);
        objMap.put(ErrorCode.NotMemberValue.mErrorCode, NotMemberValue);
        objMap.put(ErrorCode.NotValidValue.mErrorCode, NotValidValue);
        objMap.put(ErrorCode.InvalidQueryValue.mErrorCode, InvalidQueryValue);
        objMap.put(ErrorCode.MissingRequiredValue.mErrorCode, MissingRequiredValue);
        objMap.put(ErrorCode.MissingJoinValue.mErrorCode, MissingJoinValue);
        objMap.put(ErrorCode.ExceedsMaximumLength.mErrorCode, ExceedsMaximumLength);
        objMap.put(ErrorCode.RecordAlreadyModified.mErrorCode, RecordAlreadyModified);
        objMap.put(ErrorCode.ExceedsTheoreticalMaxLength.mErrorCode, ExceedsTheoreticalMaxLength);
        objMap.put(ErrorCode.PrintContainerPDFErrorNotContainer.mErrorCode, PrintContainerPDFErrorNotContainer);
        objMap.put(ErrorCode.PrintContainerPDFErrorEmpty.mErrorCode, PrintContainerPDFErrorEmpty);
        objMap.put(ErrorCode.PrintContainerPDFErrorUnsupportedType.mErrorCode, PrintContainerPDFErrorUnsupportedType);
        objMap.put(ErrorCode.PrintContainerPDFErrorPasswordRequired.mErrorCode, PrintContainerPDFErrorPasswordRequired);
        objMap.put(ErrorCode.PrintContainerPDFErrorPrintingNotAllowed.mErrorCode, PrintContainerPDFErrorPrintingNotAllowed);
        objMap.put(ErrorCode.WrongImportFileType.mErrorCode, WrongImportFileType);
        objMap.put(ErrorCode.TranslatorMissing.mErrorCode, TranslatorMissing);
        objMap.put(ErrorCode.InsufficientPrivileges.mErrorCode, InsufficientPrivileges);
        objMap.put(ErrorCode.ExcelMissingElement.mErrorCode, ExcelMissingElement);
        objMap.put(ErrorCode.ProhibitedSQLCommand.mErrorCode, ProhibitedSQLCommand);
        objMap.put(ErrorCode.IncompleteProfile.mErrorCode, IncompleteProfile);
        objMap.put(ErrorCode.XMLParserError.mErrorCode, XMLParserError);
        objMap.put(ErrorCode.XSLTransformError.mErrorCode, XSLTransformError);
        objMap.put(ErrorCode.RepeatingFieldsNotSupported.mErrorCode, RepeatingFieldsNotSupported);
        objMap.put(ErrorCode.XMLXSLExceptionError.mErrorCode, XMLXSLExceptionError);
        objMap.put(ErrorCode.ImportTargetHasNoFields.mErrorCode, ImportTargetHasNoFields);
        objMap.put(ErrorCode.ImportNoTablePermissions.mErrorCode, ImportNoTablePermissions);
        objMap.put(ErrorCode.ImportNoCreatePermission.mErrorCode, ImportNoCreatePermission);
        objMap.put(ErrorCode.ImportNoEditPermission.mErrorCode, ImportNoEditPermission);
        objMap.put(ErrorCode.ImportMoreSourceThanTarget.mErrorCode, ImportMoreSourceThanTarget);
        objMap.put(ErrorCode.ImportMoreTargetThanSource.mErrorCode, ImportMoreTargetThanSource);
        objMap.put(ErrorCode.ImportRecordsFailed.mErrorCode, ImportRecordsFailed);
        objMap.put(ErrorCode.UnsupportedExcelFileType.mErrorCode, UnsupportedExcelFileType);
        objMap.put(ErrorCode.ImportSameTableError.mErrorCode, ImportSameTableError);
        objMap.put(ErrorCode.NotAPicture.mErrorCode, NotAPicture);
        objMap.put(ErrorCode.Err_DataTruncated.mErrorCode, Err_DataTruncated);
        objMap.put(ErrorCode.CannotCreateFile.mErrorCode, CannotCreateFile);
        objMap.put(ErrorCode.CannotCreateTempFile.mErrorCode, CannotCreateTempFile);
        objMap.put(ErrorCode.CannotOpenFile.mErrorCode, CannotOpenFile);
        objMap.put(ErrorCode.CannotOpenFileInUse.mErrorCode, CannotOpenFileInUse);
        objMap.put(ErrorCode.CannotOpenAsReadOnly.mErrorCode, CannotOpenAsReadOnly);
        objMap.put(ErrorCode.CannotOpenDamagedFile.mErrorCode, CannotOpenDamagedFile);
        objMap.put(ErrorCode.CannotOpenWithThisVersion.mErrorCode, CannotOpenWithThisVersion);
        objMap.put(ErrorCode.CannotOpenUnrecognizableFile.mErrorCode, CannotOpenUnrecognizableFile);
        objMap.put(ErrorCode.DamagedAccessPrivileges.mErrorCode, DamagedAccessPrivileges);
        objMap.put(ErrorCode.DiskFull.mErrorCode, DiskFull);
        objMap.put(ErrorCode.DiskLocked.mErrorCode, DiskLocked);
        objMap.put(ErrorCode.OpenTemporaryFile.mErrorCode, OpenTemporaryFile);
        objMap.put(ErrorCode.ExceedsHostCapacity.mErrorCode, ExceedsHostCapacity);
        objMap.put(ErrorCode.LockSynchronization.mErrorCode, LockSynchronization);
        objMap.put(ErrorCode.TooManyFilesOpen.mErrorCode, TooManyFilesOpen);
        objMap.put(ErrorCode.NestedOpenFailed.mErrorCode, NestedOpenFailed);
        objMap.put(ErrorCode.CannotConvertFile.mErrorCode, CannotConvertFile);
        objMap.put(ErrorCode.CannotOpenWrongBindingKey.mErrorCode, CannotOpenWrongBindingKey);
        objMap.put(ErrorCode.InvalidPDFFileID.mErrorCode, InvalidPDFFileID);
        objMap.put(ErrorCode.InvalidPDFFile.mErrorCode, InvalidPDFFile);
        objMap.put(ErrorCode.InvalidPDFPassword.mErrorCode, InvalidPDFPassword);
        objMap.put(ErrorCode.PDFPagesModifyNotAllowed.mErrorCode, PDFPagesModifyNotAllowed);
        objMap.put(ErrorCode.PDFFileAlreadyOpen.mErrorCode, PDFFileAlreadyOpen);
        objMap.put(ErrorCode.CannotCopyRemote.mErrorCode, CannotCopyRemote);
        objMap.put(ErrorCode.FileIsClosing.mErrorCode, FileIsClosing);
        objMap.put(ErrorCode.DisconnectedFromHost.mErrorCode, DisconnectedFromHost);
        objMap.put(ErrorCode.FMIFileNotFound.mErrorCode, FMIFileNotFound);
        objMap.put(ErrorCode.NetworkGuestsConnected.mErrorCode, NetworkGuestsConnected);
        objMap.put(ErrorCode.FileIsDamaged.mErrorCode, FileIsDamaged);
        objMap.put(ErrorCode.SetLLMAccountEndpointMissingError.mErrorCode, SetLLMAccountEndpointMissingError);
        objMap.put(ErrorCode.CannotFindTblInLayoutError.mErrorCode, CannotFindTblInLayoutError);
        objMap.put(ErrorCode.CannotFindLLMAccountError.mErrorCode, CannotFindLLMAccountError);
        objMap.put(ErrorCode.LLMRequestOptionsJSONFormatParseError.mErrorCode, LLMRequestOptionsJSONFormatParseError);
        objMap.put(ErrorCode.LLMRequestParametersJSONFormatParseError.mErrorCode, LLMRequestParametersJSONFormatParseError);
        objMap.put(ErrorCode.LLMEmbeddingInvalidRequestError.mErrorCode, LLMEmbeddingInvalidRequestError);
        objMap.put(ErrorCode.LLMEmbeddingError.mErrorCode, LLMEmbeddingError);
        objMap.put(ErrorCode.LLMExtendedError.mErrorCode, LLMExtendedError);
        objMap.put(ErrorCode.LLMRepetitionFieldsNotSupported.mErrorCode, LLMRepetitionFieldsNotSupported);
        objMap.put(ErrorCode.LLMOtherLLMExtendError.mErrorCode, LLMOtherLLMExtendError);
        objMap.put(ErrorCode.LLMOtherLLMEndpointError.mErrorCode, LLMOtherLLMEndpointError);
        objMap.put(ErrorCode.LLMInvalidRequest.mErrorCode, LLMInvalidRequest);
        objMap.put(ErrorCode.LLMClarisRAGSpaceError.mErrorCode, LLMClarisRAGSpaceError);
        objMap.put(ErrorCode.LLMTrainInvalidAlgorithmError.mErrorCode, LLMTrainInvalidAlgorithmError);
        objMap.put(ErrorCode.LLMTrainInvalidParameterError.mErrorCode, LLMTrainInvalidParameterError);
        objMap.put(ErrorCode.SemanticFindNoRecordsFound.mErrorCode, SemanticFindNoRecordsFound);
        objMap.put(ErrorCode.LLMFindNoFieldsEnabled.mErrorCode, LLMFindNoFieldsEnabled);
        objMap.put(ErrorCode.kLLMTemplateNotFoundError.mErrorCode, kLLMTemplateNotFoundError);
        objMap.put(ErrorCode.kLLMTemplateModelMismatchError.mErrorCode, kLLMTemplateModelMismatchError);
        objMap.put(ErrorCode.kCannotFindLLMClarisRAGAccountError.mErrorCode, kCannotFindLLMClarisRAGAccountError);
        objMap.put(ErrorCode.kLLMFineTuneFailedJSONLFileError.mErrorCode, kLLMFineTuneFailedJSONLFileError);
        objMap.put(ErrorCode.UnsupportedXMLGrammar.mErrorCode, UnsupportedXMLGrammar);
        objMap.put(ErrorCode.NoDatabaseName.mErrorCode, NoDatabaseName);
        objMap.put(ErrorCode.MaxDBSessionsExceeded.mErrorCode, MaxDBSessionsExceeded);
        objMap.put(ErrorCode.ConflictingCommands.mErrorCode, ConflictingCommands);
        objMap.put(ErrorCode.ParameterMissing.mErrorCode, ParameterMissing);
        objMap.put(ErrorCode.TechnologyDisabled.mErrorCode, TechnologyDisabled);
        objMap.put(ErrorCode.InvalidParameter.mErrorCode, InvalidParameter);
        objMap.put(ErrorCode.WPE_NoFMHostAvailable.mErrorCode, WPE_NoFMHostAvailable);
        objMap.put(ErrorCode.WPE_IPAccessRestricted.mErrorCode, WPE_IPAccessRestricted);
        objMap.put(ErrorCode.WPE_BadPasscode.mErrorCode, WPE_BadPasscode);
        objMap.put(ErrorCode.WPE_MaxNumberOfWebEngines.mErrorCode, WPE_MaxNumberOfWebEngines);
        objMap.put(ErrorCode.ParseError.mErrorCode, ParseError);
        objMap.put(ErrorCode.CalcTooFewParams.mErrorCode, CalcTooFewParams);
        objMap.put(ErrorCode.CalcTooManyParams.mErrorCode, CalcTooManyParams);
        objMap.put(ErrorCode.CalcUnexpectedEnd.mErrorCode, CalcUnexpectedEnd);
        objMap.put(ErrorCode.CalcUnexpectedToken.mErrorCode, CalcUnexpectedToken);
        objMap.put(ErrorCode.CalcUnterminatedCmmt.mErrorCode, CalcUnterminatedCmmt);
        objMap.put(ErrorCode.CalcUnterminatedString.mErrorCode, CalcUnterminatedString);
        objMap.put(ErrorCode.CalcUnbalancedParen.mErrorCode, CalcUnbalancedParen);
        objMap.put(ErrorCode.CalcUnknownFunction.mErrorCode, CalcUnknownFunction);
        objMap.put(ErrorCode.CalcUnknownName.mErrorCode, CalcUnknownName);
        objMap.put(ErrorCode.CalcAlreadyRegistered.mErrorCode, CalcAlreadyRegistered);
        objMap.put(ErrorCode.CalcListUsage.mErrorCode, CalcListUsage);
        objMap.put(ErrorCode.CalcOperatorMissing.mErrorCode, CalcOperatorMissing);
        objMap.put(ErrorCode.CalcVariableNotUnique.mErrorCode, CalcVariableNotUnique);
        objMap.put(ErrorCode.CalcExpectedFieldOnly.mErrorCode, CalcExpectedFieldOnly);
        objMap.put(ErrorCode.CalcInvalidGetFlag.mErrorCode, CalcInvalidGetFlag);
        objMap.put(ErrorCode.CalcSummaryFieldOnly.mErrorCode, CalcSummaryFieldOnly);
        objMap.put(ErrorCode.CalcInvalidBreakField.mErrorCode, CalcInvalidBreakField);
        objMap.put(ErrorCode.CalcBadFmt.mErrorCode, CalcBadFmt);
        objMap.put(ErrorCode.CalcCircularFormula.mErrorCode, CalcCircularFormula);
        objMap.put(ErrorCode.CalcInvalidSummarizedFieldType.mErrorCode, CalcInvalidSummarizedFieldType);
        objMap.put(ErrorCode.CalcInvalidSummarizedDataType.mErrorCode, CalcInvalidSummarizedDataType);
        objMap.put(ErrorCode.CalcCannotBeStored.mErrorCode, CalcCannotBeStored);
        objMap.put(ErrorCode.CalcUnimplemented.mErrorCode, CalcUnimplemented);
        objMap.put(ErrorCode.CalcUndefined.mErrorCode, CalcUndefined);
        objMap.put(ErrorCode.CalcFunctionNotSupported.mErrorCode, CalcFunctionNotSupported);
        objMap.put(ErrorCode.PoorName.mErrorCode, PoorName);
        objMap.put(ErrorCode.ODBCComponentsNotInstalled.mErrorCode, ODBCComponentsNotInstalled);
        objMap.put(ErrorCode.ODBCFailedToAllocateEnvironment.mErrorCode, ODBCFailedToAllocateEnvironment);
        objMap.put(ErrorCode.ODBCFailedToFreeEnvironment.mErrorCode, ODBCFailedToFreeEnvironment);
        objMap.put(ErrorCode.ODBCFailedToDisconnect.mErrorCode, ODBCFailedToDisconnect);
        objMap.put(ErrorCode.ODBCFailedToAllocateConnection.mErrorCode, ODBCFailedToAllocateConnection);
        objMap.put(ErrorCode.ODBCFailedToFreeConnection.mErrorCode, ODBCFailedToFreeConnection);
        objMap.put(ErrorCode.ODBCFailedCheckForSQLAPI.mErrorCode, ODBCFailedCheckForSQLAPI);
        objMap.put(ErrorCode.ODBCFailedToAllocateStatement.mErrorCode, ODBCFailedToAllocateStatement);
        objMap.put(ErrorCode.ODBCExtendedError.mErrorCode, ODBCExtendedError);
        objMap.put(ErrorCode.ODBCErrorNoInfo.mErrorCode, ODBCErrorNoInfo);
        objMap.put(ErrorCode.ODBCCommLinkError.mErrorCode, ODBCCommLinkError);
        objMap.put(ErrorCode.NoPHPPrivileges.mErrorCode, ODBCCommLinkError);
        objMap.put(ErrorCode.MustBeRemoteFile.mErrorCode, MustBeRemoteFile);
        objMap.put(ErrorCode.ScriptRunning.mErrorCode, ScriptRunning);
        objMap.put(ErrorCode.SMTPAuthenticationFailed.mErrorCode, SMTPAuthenticationFailed);
        objMap.put(ErrorCode.SMTPConnectionRefused.mErrorCode, SMTPConnectionRefused);
        objMap.put(ErrorCode.SMTPSSLError.mErrorCode, SMTPSSLError);
        objMap.put(ErrorCode.SMTPEncryptionRequired.mErrorCode, SMTPEncryptionRequired);
        objMap.put(ErrorCode.SMTPAuthenticationNotSupported.mErrorCode, SMTPAuthenticationNotSupported);
        objMap.put(ErrorCode.SMTPEmailSendFailed.mErrorCode, SMTPEmailSendFailed);
        objMap.put(ErrorCode.SMTPLoginError.mErrorCode, SMTPLoginError);
        objMap.put(ErrorCode.OAuthSendMailFailed.mErrorCode, OAuthSendMailFailed);
        objMap.put(ErrorCode.OAuthRequestAccessTokenFailed.mErrorCode, OAuthRequestAccessTokenFailed);
        objMap.put(ErrorCode.URLConnectionUnsupportedProtocol.mErrorCode, URLConnectionUnsupportedProtocol);
        objMap.put(ErrorCode.URLConnectionAuthenticationFalied.mErrorCode, URLConnectionAuthenticationFalied);
        objMap.put(ErrorCode.URLConnectionSSLError.mErrorCode, URLConnectionSSLError);
        objMap.put(ErrorCode.URLConnectionTimeout.mErrorCode, URLConnectionTimeout);
        objMap.put(ErrorCode.URLConnectionMalformat.mErrorCode, URLConnectionMalformat);
        objMap.put(ErrorCode.URLConnectionGeneralFail.mErrorCode, URLConnectionGeneralFail);
        objMap.put(ErrorCode.URLConnectionSSLCertificateExpired.mErrorCode, URLConnectionSSLCertificateExpired);
        objMap.put(ErrorCode.URLConnectionSSLCertificateSelfSigned.mErrorCode, URLConnectionSSLCertificateSelfSigned);
        objMap.put(ErrorCode.URLConnectionSSLCertificateVerificationError.mErrorCode, URLConnectionSSLCertificateVerificationError);
        objMap.put(ErrorCode.BlockNewUsers.mErrorCode, BlockNewUsers);
        objMap.put(ErrorCode.ODBCDataSourceUsageError.mErrorCode, ODBCDataSourceUsageError);
        objMap.put(ErrorCode.QuickFindNoRecordsFound.mErrorCode, QuickFindNoRecordsFound);
        objMap.put(ErrorCode.QuickFindEmptyQuery.mErrorCode, QuickFindEmptyQuery);
        objMap.put(ErrorCode.QuickFindNoFieldsEnabled.mErrorCode, QuickFindNoFieldsEnabled);
        objMap.put(ErrorCode.NonIndexableFieldClient.mErrorCode, NonIndexableFieldClient);
        objMap.put(ErrorCode.ScriptTriggered.mErrorCode, ScriptTriggered);
        objMap.put(ErrorCode.WarnRevertRecord.mErrorCode, WarnRevertRecord);
        objMap.put(ErrorCode.WarnRevertRequest.mErrorCode, WarnRevertRequest);
        objMap.put(ErrorCode.WarnDeleteFoundSet.mErrorCode, WarnDeleteFoundSet);
        objMap.put(ErrorCode.WarnDeleteAll.mErrorCode, WarnDeleteAll);
        objMap.put(ErrorCode.WarnDeleteRecord.mErrorCode, WarnDeleteRecord);
        objMap.put(ErrorCode.WarnDeleteRelatedRecord.mErrorCode, WarnDeleteRelatedRecord);
        objMap.put(ErrorCode.WarnFindMode.mErrorCode, WarnFindMode);
        objMap.put(ErrorCode.WarnRelookup.mErrorCode, WarnRelookup);
        objMap.put(ErrorCode.WarnReplaceAll.mErrorCode, WarnReplaceAll);
        objMap.put(ErrorCode.WarnCommitRecord.mErrorCode, WarnCommitRecord);
        objMap.put(ErrorCode.WarnLayoutChange.mErrorCode, WarnLayoutChange);
        objMap.put(ErrorCode.ObjectLocked.mErrorCode, ObjectLocked);
        objMap.put(ErrorCode.ScriptLocked.mErrorCode, ScriptLocked);
        objMap.put(ErrorCode.ScriptLockedByCatalog.mErrorCode, ScriptLockedByCatalog);
        objMap.put(ErrorCode.ScriptsLocked.mErrorCode, ScriptsLocked);
        objMap.put(ErrorCode.SortOrderChanged.mErrorCode, SortOrderChanged);
        objMap.put(ErrorCode.Err_MustHaveFieldSelected.mErrorCode, Err_MustHaveFieldSelected);
        objMap.put(ErrorCode.Err_PlugInExceptionCaught.mErrorCode, Err_PlugInExceptionCaught);
        objMap.put(ErrorCode.Warn_LibraryObjectExists.mErrorCode, Warn_LibraryObjectExists);
        objMap.put(ErrorCode.ODBCNothingToDisconnect.mErrorCode, ODBCNothingToDisconnect);
        objMap.put(ErrorCode.ODBCMissingUserPassword.mErrorCode, ODBCMissingUserPassword);
        objMap.put(ErrorCode.ODBCErrorNoData.mErrorCode, ODBCErrorNoData);
        objMap.put(ErrorCode.LockNotPresent.mErrorCode, LockNotPresent);
        objMap.put(ErrorCode.LockMustWait.mErrorCode, LockMustWait);
        objMap.put(ErrorCode.LockCanceled.mErrorCode, LockCanceled);
        objMap.put(ErrorCode.LockConflict.mErrorCode, LockConflict);
        objMap.put(ErrorCode.LockSchemaNotSynced.mErrorCode, LockSchemaNotSynced);
        objMap.put(ErrorCode.LockInvalidUpgradeType.mErrorCode, LockInvalidUpgradeType);
        objMap.put(ErrorCode.WarningPoorName.mErrorCode, WarningPoorName);
        objMap.put(ErrorCode.JoinGraphCycle.mErrorCode, JoinGraphCycle);
        objMap.put(ErrorCode.InvalidSelfJoin.mErrorCode, InvalidSelfJoin);
        objMap.put(ErrorCode.InvalidJoinFields.mErrorCode, InvalidJoinFields);
        objMap.put(ErrorCode.TooManyTables.mErrorCode, TooManyTables);
        objMap.put(ErrorCode.CircularValueListDef.mErrorCode, CircularValueListDef);
        objMap.put(ErrorCode.NonIndexableField.mErrorCode, NonIndexableField);
        objMap.put(ErrorCode.IndexRequired.mErrorCode, IndexRequired);
        objMap.put(ErrorCode.CannotChangeFieldType.mErrorCode, CannotChangeFieldType);
        objMap.put(ErrorCode.SelectFieldfromEachList.mErrorCode, SelectFieldfromEachList);
        objMap.put(ErrorCode.FieldUsedInPrivileges.mErrorCode, FieldUsedInPrivileges);
        objMap.put(ErrorCode.NeedToRebuildDependecies.mErrorCode, NeedToRebuildDependecies);
        objMap.put(ErrorCode.SyncShadowFieldDupName.mErrorCode, SyncShadowFieldDupName);
        objMap.put(ErrorCode.InvalidTempTableUsage.mErrorCode, InvalidTempTableUsage);
        objMap.put(ErrorCode.NonMatchingColumns.mErrorCode, NonMatchingColumns);
        objMap.put(ErrorCode.InvalidTable.mErrorCode, InvalidTable);
        objMap.put(ErrorCode.InvalidScalarQuery.mErrorCode, InvalidScalarQuery);
        objMap.put(ErrorCode.DdlDuringOpenTransaction.mErrorCode, DdlDuringOpenTransaction);
        objMap.put(ErrorCode.IndexAlreadyExists.mErrorCode, IndexAlreadyExists);
        objMap.put(ErrorCode.NoExternalSchemaChange.mErrorCode, NoExternalSchemaChange);
        objMap.put(ErrorCode.CannotLockForUpdate.mErrorCode, CannotLockForUpdate);
        objMap.put(ErrorCode.ContinueAuthentication.mErrorCode, ContinueAuthentication);
        objMap.put(ErrorCode.HasUserAccounts.mErrorCode, HasUserAccounts);
        objMap.put(ErrorCode.CannotDuplicateAdministrator.mErrorCode, CannotDuplicateAdministrator);
        objMap.put(ErrorCode.InvalidCreatePrivileges.mErrorCode, InvalidCreatePrivileges);
        objMap.put(ErrorCode.CallbackScriptFailed.mErrorCode, CallbackScriptFailed);
        objMap.put(ErrorCode.EventNoReply.mErrorCode, EventNoReply);
        objMap.put(ErrorCode.EventInvalidParam.mErrorCode, EventInvalidParam);
        objMap.put(ErrorCode.EventTimedOut.mErrorCode, EventTimedOut);
        objMap.put(ErrorCode.HelperUnavailable.mErrorCode, HelperUnavailable);
        objMap.put(ErrorCode.ServerUnavailable.mErrorCode, ServerUnavailable);
        objMap.put(ErrorCode.DependencyMissing.mErrorCode, DependencyMissing);
        objMap.put(ErrorCode.ServiceAlreadyRunning.mErrorCode, ServiceAlreadyRunning);
        objMap.put(ErrorCode.ObjectNotExist.mErrorCode, ObjectNotExist);
        objMap.put(ErrorCode.InvalidObjectType.mErrorCode, InvalidObjectType);
        objMap.put(ErrorCode.ObjectAlreadyExists.mErrorCode, ObjectAlreadyExists);
        objMap.put(ErrorCode.ComponentIncompatible.mErrorCode, ComponentIncompatible);
        objMap.put(ErrorCode.ServerIncompatible.mErrorCode, ServerIncompatible);
        objMap.put(ErrorCode.NotEnoughSpace.mErrorCode, NotEnoughSpace);
        objMap.put(ErrorCode.HostUnreachable.mErrorCode, HostUnreachable);
        objMap.put(ErrorCode.HostIncompatibleVersion.mErrorCode, HostIncompatibleVersion);
        objMap.put(ErrorCode.CannotDisconnectAdmin.mErrorCode, CannotDisconnectAdmin);
        objMap.put(ErrorCode.ScheduleMissing.mErrorCode, ScheduleMissing);
        objMap.put(ErrorCode.ScheduleBadConfiguration.mErrorCode, ScheduleBadConfiguration);
        objMap.put(ErrorCode.ScheduleCreationError.mErrorCode, ScheduleCreationError);
        objMap.put(ErrorCode.ScheduleCannotBeEnabled.mErrorCode, ScheduleCannotBeEnabled);
        objMap.put(ErrorCode.ScheduleBadTarget.mErrorCode, ScheduleBadTarget);
        objMap.put(ErrorCode.ScheduleBadBackupDest.mErrorCode, ScheduleBadBackupDest);
        objMap.put(ErrorCode.ScheduleBadScriptTarget.mErrorCode, ScheduleBadScriptTarget);
        objMap.put(ErrorCode.ScheduleInvalidAccount.mErrorCode, ScheduleInvalidAccount);
        objMap.put(ErrorCode.BackupDestNoPermission.mErrorCode, BackupDestNoPermission);
        objMap.put(ErrorCode.BackupDestNotFolder.mErrorCode, BackupDestNotFolder);
        objMap.put(ErrorCode.BackupDestDiskFull.mErrorCode, BackupDestDiskFull);
        objMap.put(ErrorCode.BackupVerifyFailed.mErrorCode, BackupVerifyFailed);
        objMap.put(ErrorCode.ResourceNotFound.mErrorCode, ResourceNotFound);
        objMap.put(ErrorCode.LocaleNotFound.mErrorCode, LocaleNotFound);
        objMap.put(ErrorCode.EngineOffline.mErrorCode, EngineOffline);
        objMap.put(ErrorCode.EngineTooManyOpenFiles.mErrorCode, EngineTooManyOpenFiles);
        objMap.put(ErrorCode.EngineFileNotOpen.mErrorCode, EngineFileNotOpen);
        objMap.put(ErrorCode.EngineFileSameNameOpen.mErrorCode, EngineFileSameNameOpen);
        objMap.put(ErrorCode.EngineNoFilesForOperation.mErrorCode, EngineNoFilesForOperation);
        objMap.put(ErrorCode.WPEValidURLGood.mErrorCode, WPEValidURLGood);
        objMap.put(ErrorCode.NamedScriptMissing.mErrorCode, NamedScriptMissing);
        objMap.put(ErrorCode.ScriptMakerAborted.mErrorCode, ScriptMakerAborted);
        objMap.put(ErrorCode.SystemScriptAborted.mErrorCode, SystemScriptAborted);
        objMap.put(ErrorCode.SystemScriptReturnedNonZero.mErrorCode, SystemScriptReturnedNonZero);
        objMap.put(ErrorCode.FmsInvalidCommand.mErrorCode, FmsInvalidCommand);
        objMap.put(ErrorCode.InvalidOption.mErrorCode, InvalidOption);
        objMap.put(ErrorCode.CommandMissing.mErrorCode, CommandMissing);
        objMap.put(ErrorCode.UserRejectedConfirmation.mErrorCode, UserRejectedConfirmation);
        objMap.put(ErrorCode.DisconnectGuestInvalidCommand.mErrorCode, DisconnectGuestInvalidCommand);
        objMap.put(ErrorCode.DisconnectGuestInvalidClientID.mErrorCode, DisconnectGuestInvalidClientID);
        objMap.put(ErrorCode.LastServerError.mErrorCode, LastServerError);
        objMap.put(ErrorCode.CannotReadStream.mErrorCode, CannotReadStream);
        objMap.put(ErrorCode.NoStyleRuns.mErrorCode, NoStyleRuns);
        objMap.put(ErrorCode.StyleNotFound.mErrorCode, StyleNotFound);
        objMap.put(ErrorCode.CannotReadStyles.mErrorCode, CannotReadStyles);
        objMap.put(ErrorCode.CannotWriteStyles.mErrorCode, CannotWriteStyles);
        objMap.put(ErrorCode.BufferIsFull.mErrorCode, BufferIsFull);
        objMap.put(ErrorCode.NoStream.mErrorCode, NoStream);
        objMap.put(ErrorCode.UnicodeInternal.mErrorCode, UnicodeInternal);
        objMap.put(ErrorCode.UnicodeBufferTooSmall.mErrorCode, UnicodeBufferTooSmall);
        objMap.put(ErrorCode.CannotSet.mErrorCode, CannotSet);
        objMap.put(ErrorCode.UnicodeConversionError.mErrorCode, UnicodeConversionError);
        objMap.put(ErrorCode.UnknownUniversalPathType.mErrorCode, UnknownUniversalPathType);
        objMap.put(ErrorCode.Cancelled.mErrorCode, Cancelled);
        objMap.put(ErrorCode.EndOfFile.mErrorCode, EndOfFile);
        objMap.put(ErrorCode.Permission.mErrorCode, Permission);
        objMap.put(ErrorCode.Specification.mErrorCode, Specification);
        objMap.put(ErrorCode.FileNotOpen.mErrorCode, FileNotOpen);
        objMap.put(ErrorCode.FileNotFound.mErrorCode, FileNotFound);
        objMap.put(ErrorCode.FileExists.mErrorCode, FileExists);
        objMap.put(ErrorCode.AlreadyOpen.mErrorCode, AlreadyOpen);
        objMap.put(ErrorCode.Read.mErrorCode, Read);
        objMap.put(ErrorCode.Write.mErrorCode, Write);
        objMap.put(ErrorCode.IO.mErrorCode, IO);
        objMap.put(ErrorCode.AsyncNotAllowed.mErrorCode, AsyncNotAllowed);
        objMap.put(ErrorCode.ForkNotFound.mErrorCode, ForkNotFound);
        objMap.put(ErrorCode.DirectoryNotFound.mErrorCode, DirectoryNotFound);
        objMap.put(ErrorCode.DirectoryNotEmpty.mErrorCode, DirectoryNotEmpty);
        objMap.put(ErrorCode.NetInitializationErr.mErrorCode, NetInitializationErr);
        objMap.put(ErrorCode.NetCannotHostErr.mErrorCode, NetCannotHostErr);
        objMap.put(ErrorCode.NetConnectionErr.mErrorCode, NetConnectionErr);
        objMap.put(ErrorCode.NetCommunicationsErr.mErrorCode, NetCommunicationsErr);
        objMap.put(ErrorCode.InstallCodeConflict.mErrorCode, InstallCodeConflict);
        objMap.put(ErrorCode.PostNetCommunicationsErr.mErrorCode, PostNetCommunicationsErr);
        objMap.put(ErrorCode.WPEAlreadyRunning.mErrorCode, WPEAlreadyRunning);
        objMap.put(ErrorCode.WPEAlreadyStopping.mErrorCode, WPEAlreadyStopping);
        objMap.put(ErrorCode.WPEInitFailure.mErrorCode, WPEInitFailure);
        objMap.put(ErrorCode.InvalidSessionID.mErrorCode, InvalidSessionID);
        objMap.put(ErrorCode.InvalidAuthentication.mErrorCode, InvalidAuthentication);
        objMap.put(ErrorCode.PluginFailedToInit.mErrorCode, PluginFailedToInit);
        objMap.put(ErrorCode.PluginCantInstall.mErrorCode, PluginCantInstall);
    }
}

