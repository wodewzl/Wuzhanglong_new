package com.wzl.caipiao;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.bingoogolapple.baseadapter.BGAOnRVItemLongClickListener;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener, BGAOnRVItemLongClickListener {
    private EditText mNumberEt;
    private TextView mTv1, mTv2, mTv3, mTv4, mTv5, mCommitTv;
    //    private List<String> mList = new ArrayList<>();
    private LuRecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;
    private double mBackPressed;
//    private int mPreCount=280;
        private int mPreCount=150;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("预测");
        mBaseOkTv.setText("保存");
        mBaseBackTv.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        mBaseBackTv.setText("150");
        mNumberEt = getViewById(R.id.number_et);
        mTv1 = getViewById(R.id.tv_1);
        mTv2 = getViewById(R.id.tv_2);
        mTv3 = getViewById(R.id.tv_3);
        mTv4 = getViewById(R.id.tv_4);
        mTv5 = getViewById(R.id.tv_5);
        mCommitTv = getViewById(R.id.commit_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mMainAdapter = new MainAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mMainAdapter, R.dimen.dp_1, R.color.colorAccent, false);

//        if (AppApplication.getInstance().getDataVO() != null) {
//            List<UserInfoVO> list = AppApplication.getInstance().getDataVO();
//            mMainAdapter.updateDataFrist(list);
//        }

        String reslut = ACache.get(this).getAsString("result_str");
//        String reslut="45021137269565292670880842400713963449883400306103550883658552888401673471897837657524357114857110103924103548062401490221923213080060623313081632235039838396042930434999587817411346330506348899417247661807333389689244530307525505424585007576617957617263517076470404578276018377812539865857375242383732489049592895099397248406437533326097039188937047578152777257296519334917920806017742753160081537107535860582506783862508024857184071423403504539328598210746185101321845537451143314478766079580867127227770493679099441471335366317932189406211225617749486244995988664237766487849164543719980665548447285935449997509765785237216094727413998287938456196837420552052223290476533700306568498289872010472399628049532703447280893949429961668540183133879721848401837651426331157157909600564658975950085071817000021436936648819521411825142906554002454996163909629761159741149891204668973932751717702291866770807289231880340172733284943568859595869845773228022266658911120908926588939506868087272435222445092779615618272951749300676405564160081140039026069829963766288569916269571528332366946929867361468975395516921980298720253813944509781881383413459825560253661143358467702092831415318822048165553019224785093259602865071790700754023716305747452426189479607501701282341403266940953354008622470628660750759805027739998919672847126423069717541003958049192032785835182835870628658851489227796067071816936122740884432378867235898775832962672523497614025378352682977085854674278688160295231228856230578546032145035240772894124574731831728581652836868152982998497957789519053444126080859472202618822759017998307166979936367525071016809924205889575196497418299731540999598418104501888719287601100641889726803122980282423688592655289439150677315535080048887478377415638686015591089178426708691449437708135898310764266339755530881238733489984828731745096361919763121665900718601715854105876852095606468470460086854997088073592660702478408138532213926468750498381766430611168529932920869467279843016439984628819240445821068005302725737659600064302278462652441851301630184173926996722912105661723621192528280652896994852304177382236877244350572602030824168229086677790130551020203649812955237989750957784712437215783393298657477760220536692090019715662794758821104980729475637521903047431588441614070583404707586480084486036447002149651495561840342133374241137328329106723189228048231062693027689184800435699993862057503616100610449677223686528852932012013666345719556367966087575002408941575531942038703228574182037417411376924522407629837549764692093107524849700487722180924468214959985829208725811723292376153134147779609573430509146447081213055092170161154494016902924714207555430605817227628029056686858635965756028070291033095331120765719143264566528739063432944006128105087839160639075252159115274103568747957639368005495256940608336244495689092325790905934918482710869423227700205351996579907231982856147270861795360340996847259480886368089332155457395140952964624286554235385189857334149553981646026349324870759424019645350817317754329425759997078971175927327277465513437334413430163120341502879607528304870915215868362343895321656361812637762204028309268736357742803831725980893619413644968685841855016694917759940860137200729425907291704004257502998468063857708046120239636619130829571590270389554352129525013173631230832634690374124172330076373863571000509103365577225937751913508646364254114960689644121492779213106123536622898630927941515562014499191502799754075287219670949809156737141869870270456520196887699498203922873777989972859480588331045209724976803813036960745593503712787254111111720300793076703975500700688092015016507108010048221303313198480349699134727061900250456872579905487403558082884725850787262030168121536514206679314625275352967718542057540162527501221432109278670229221881416613714422219304751552820050566129092876026872048503685664087146418554723282609239971032275061635447198181740432193907757584949832647342861387370487299738629843473150845039764490000347993630193369010436483756690923308784705031204905777620341476471626422189023530045059562443402298694060753200533712901519781311142877069612987890388173468612461284301954367645952056526300146503753523602067336191088644645861249344384656037754494432847433001478790404358887313700984364936016024073";
        List<UserInfoVO> list = new ArrayList<>();
        for (int i = 0; i < reslut.length(); i++) {
            UserInfoVO userInfoVO = new UserInfoVO();
            userInfoVO.setResult(String.valueOf(reslut.charAt(i)));
            list.add(userInfoVO);
        }
        countData(list);
    }

    @Override
    public void bindViewsListener() {
        mCommitTv.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
        mMainAdapter.setOnRVItemLongClickListener(this);
        mBaseBackTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_tv:
                StringBuffer sb = new StringBuffer(mNumberEt.getText().toString());
//                sb.reverse();
                String reslut = sb.toString();

//                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < 150; i++) {
//                    Random random=new Random();
//                    String str= random.nextInt(10)+"";
//                    sb.append(str);
//                }
//                String reslut = sb.toString();

                if (TextUtils.isEmpty(reslut)) {
                    showCustomToast("请输入开奖结果");
                    return;
                }
                List<UserInfoVO> list = new ArrayList<>();
                for (int i = 0; i < reslut.length(); i++) {
                    UserInfoVO userInfoVO = new UserInfoVO();
                    userInfoVO.setResult(String.valueOf(reslut.charAt(i)));
                    list.add(userInfoVO);
                }
//                mMainAdapter.updateDataFrist(list);
                countData(list);
                mNumberEt.setText("");
                break;
            case R.id.base_ok_tv:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要保存数据吗吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();//直接消失
                                AppApplication.getInstance().saveDataVO(mMainAdapter.getData());
//                                UserInfoVO dataVO = new UserInfoVO();
//                                dataVO.setList(mMainAdapter.getData());
                                StringBuffer sb = new StringBuffer();
                                for (int i = 0; i < mMainAdapter.getData().size(); i++) {
                                    sb.append(((UserInfoVO) mMainAdapter.getData().get(i)).getResult());
                                }
                                sb.reverse();
                                ACache.get(MainActivity.this).put("result_str", sb.toString());
                            }
                        })
                        .show();
                break;
            case R.id.base_back_tv:
                if(mPreCount==120){
                    mPreCount=150;
                }else if(mPreCount==150){
                    mPreCount=180;
                }else if(mPreCount==180){
                    mPreCount=100;
                }else if(mPreCount==100){
                    mPreCount=80;
                }else if(mPreCount==80){
                    mPreCount=120;
                }
                mBaseBackTv.setText(mPreCount+"");
                showCustomToast("统计前："+mPreCount);
                String reslutStr = ACache.get(this).getAsString("result_str");
//        String reslut="45021137269565292670880842400713963449883400306103550883658552888401673471897837657524357114857110103924103548062401490221923213080060623313081632235039838396042930434999587817411346330506348899417247661807333389689244530307525505424585007576617957617263517076470404578276018377812539865857375242383732489049592895099397248406437533326097039188937047578152777257296519334917920806017742753160081537107535860582506783862508024857184071423403504539328598210746185101321845537451143314478766079580867127227770493679099441471335366317932189406211225617749486244995988664237766487849164543719980665548447285935449997509765785237216094727413998287938456196837420552052223290476533700306568498289872010472399628049532703447280893949429961668540183133879721848401837651426331157157909600564658975950085071817000021436936648819521411825142906554002454996163909629761159741149891204668973932751717702291866770807289231880340172733284943568859595869845773228022266658911120908926588939506868087272435222445092779615618272951749300676405564160081140039026069829963766288569916269571528332366946929867361468975395516921980298720253813944509781881383413459825560253661143358467702092831415318822048165553019224785093259602865071790700754023716305747452426189479607501701282341403266940953354008622470628660750759805027739998919672847126423069717541003958049192032785835182835870628658851489227796067071816936122740884432378867235898775832962672523497614025378352682977085854674278688160295231228856230578546032145035240772894124574731831728581652836868152982998497957789519053444126080859472202618822759017998307166979936367525071016809924205889575196497418299731540999598418104501888719287601100641889726803122980282423688592655289439150677315535080048887478377415638686015591089178426708691449437708135898310764266339755530881238733489984828731745096361919763121665900718601715854105876852095606468470460086854997088073592660702478408138532213926468750498381766430611168529932920869467279843016439984628819240445821068005302725737659600064302278462652441851301630184173926996722912105661723621192528280652896994852304177382236877244350572602030824168229086677790130551020203649812955237989750957784712437215783393298657477760220536692090019715662794758821104980729475637521903047431588441614070583404707586480084486036447002149651495561840342133374241137328329106723189228048231062693027689184800435699993862057503616100610449677223686528852932012013666345719556367966087575002408941575531942038703228574182037417411376924522407629837549764692093107524849700487722180924468214959985829208725811723292376153134147779609573430509146447081213055092170161154494016902924714207555430605817227628029056686858635965756028070291033095331120765719143264566528739063432944006128105087839160639075252159115274103568747957639368005495256940608336244495689092325790905934918482710869423227700205351996579907231982856147270861795360340996847259480886368089332155457395140952964624286554235385189857334149553981646026349324870759424019645350817317754329425759997078971175927327277465513437334413430163120341502879607528304870915215868362343895321656361812637762204028309268736357742803831725980893619413644968685841855016694917759940860137200729425907291704004257502998468063857708046120239636619130829571590270389554352129525013173631230832634690374124172330076373863571000509103365577225937751913508646364254114960689644121492779213106123536622898630927941515562014499191502799754075287219670949809156737141869870270456520196887699498203922873777989972859480588331045209724976803813036960745593503712787254111111720300793076703975500700688092015016507108010048221303313198480349699134727061900250456872579905487403558082884725850787262030168121536514206679314625275352967718542057540162527501221432109278670229221881416613714422219304751552820050566129092876026872048503685664087146418554723282609239971032275061635447198181740432193907757584949832647342861387370487299738629843473150845039764490000347993630193369010436483756690923308784705031204905777620341476471626422189023530045059562443402298694060753200533712901519781311142877069612987890388173468612461284301954367645952056526300146503753523602067336191088644645861249344384656037754494432847433001478790404358887313700984364936016024073";
                List<UserInfoVO> listRefrsh = new ArrayList<>();
                for (int i = 0; i < reslutStr.length(); i++) {
                    UserInfoVO userInfoVO = new UserInfoVO();
                    userInfoVO.setResult(String.valueOf(reslutStr.charAt(i)));
                    listRefrsh.add(userInfoVO);
                }
                countData(listRefrsh);
                break;
            default:
                break;
        }


    }

    private static String sortMapByValue(Map<String, Integer> map) {
        StringBuffer sb = new StringBuffer();
        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(
                map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : mapList) {
//            result.put(entry.getKey(), entry.getValue());
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public void countData(List<UserInfoVO> list) {
        if (list == null)
            return;

        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.isEmpty(mTv3.getText().toString())) {
                list.get(i).setYuce1(mTv3.getText().toString());
            }
            mMainAdapter.getData().add(0, list.get(i));

            if (!TextUtils.isEmpty(mTv4.getText().toString())) {
                list.get(i).setYuce2(mTv4.getText().toString());
            }

            if (!TextUtils.isEmpty(mTv5.getText().toString())) {
                list.get(i).setYuce3(mTv5.getText().toString());
            }

            StringBuffer sb1 = new StringBuffer();
            StringBuffer sb2 = new StringBuffer();
            HashMap<String, Integer> map = new HashMap<String, Integer>();

            if (i == list.size() - 3) {
                System.out.println("=======");
            }


            for (int j = 0; j < mMainAdapter.getData().size(); j++) {
                if(j>mPreCount)
                    break;
                //统计双数
                if (sb1.toString().contains(((UserInfoVO) mMainAdapter.getData().get(j)).getResult())) {
                    if (!sb2.toString().contains(((UserInfoVO) mMainAdapter.getData().get(j)).getResult())) {
                        sb2.append(((UserInfoVO) mMainAdapter.getData().get(j)).getResult());
                    }
                } else {
                    sb1.append(((UserInfoVO) mMainAdapter.getData().get(j)).getResult());
                }
                String tv1Str = sb2.toString();
                mTv1.setText(tv1Str);


                //统计数量
                if (mMainAdapter.getData().size() > mPreCount ) {
                    String key = ((UserInfoVO) mMainAdapter.getData().get(j)).getResult();
                    Integer count = map.get(key);
                    if (count == null) {
                        count = 1;
                    } else {
                        count++;
                    }
                    map.put(key, count);
                }

            }

            if (sb2.toString().length() > 1) {
                mTv3.setText(sb2.toString().substring(0, 2));
//                ((UserInfoVO) mMainAdapter.getData().get(i)).setYuce1(mTv3.getText().toString());
            }

            if (mMainAdapter.getData().size() > mPreCount) {
                String tv2Str = sortMapByValue(map);
                mTv2.setText(tv2Str);
                if (tv2Str.length() > 1) {
                    mTv4.setText(tv2Str.substring(0, 2));
//                    mTv5.setText(tv2Str.substring(tv2Str.length()-2,tv2Str.length()));
                    mTv5.setText(tv2Str);

                }
            }

        }
        mMainAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (isShow()) {
//            dismissProgressDialog();
        } else {
            if (mBackPressed + 3000 > System.currentTimeMillis()) {
                finish();
                super.onBackPressed();
            } else
                showCustomToast("再次点击，退出" + this.getResources().getString(R.string.app_name));
            mBackPressed = System.currentTimeMillis();
        }
    }

    @Override
    public boolean onRVItemLongClick(ViewGroup parent, View itemView, final int position) {
        if (mMainAdapter.getData().size() == 0)
            return false;
        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("确定要删除吗?")
                .setConfirmText("确定")
                .setCancelText("取消")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();//直接消失
                        mMainAdapter.getData().remove(position);
                        mMainAdapter.notifyDataSetChanged();
                    }
                })
                .show();

        return false;
    }
}
