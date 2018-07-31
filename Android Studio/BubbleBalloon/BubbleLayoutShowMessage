public class BubbleLayoutShowMessage {

    public static void showWarningRight(@NonNull Context context, @NonNull View v, @NonNull String message, int tamanhoMessage) {
        View view = LayoutInflater.from(context).inflate(R.layout.bubble_layout_right, null);
        view.setLayoutParams(new LinearLayoutCompat.LayoutParams(tamanhoMessage, LinearLayoutCompat.LayoutParams.WRAP_CONTENT));
        TextView text = view.findViewById(R.id.textViewHelp);
        text.setText(message);
        BubbleLayout bubbleLayout = (BubbleLayout) view;
        PopupWindow popupWindow = BubblePopupHelper.create(context, bubbleLayout);
        int[] tamanhoIcon = new int[2];
        v.getLocationInWindow(tamanhoIcon);
        popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, tamanhoIcon[0] - tamanhoMessage, tamanhoIcon[1]);
    }
}