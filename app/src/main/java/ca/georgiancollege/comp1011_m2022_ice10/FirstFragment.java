package ca.georgiancollege.comp1011_m2022_ice10;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import ca.georgiancollege.comp1011_m2022_ice10.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        // listener
        binding.clickMeButton.setOnClickListener(new View.OnClickListener()
        {
            // Handler
            @Override
            public void onClick(View view)
            {
                Log.i("info",binding.helloWorldLabel.getText().toString());

                // toggle the text of the helloWorldLabel every time the ClickMe button is clicked
                binding.helloWorldLabel.setText(
                        (binding.helloWorldLabel.getText().equals("Hello, World!")) ? R.string.goodbye_world : R.string.hello_world);

                Log.i("info", "onClick Button was clicked!");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}