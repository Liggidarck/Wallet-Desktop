package com.george.wallet_desktop.util;

import com.george.wallet_desktop.WalletApplication;

import java.util.Objects;

public class Keys {

    public static final String DATABASE_LOCATION = Objects.requireNonNull(
                    WalletApplication.class.getResource("database/wallet.db"))
            .toExternalForm();


}
